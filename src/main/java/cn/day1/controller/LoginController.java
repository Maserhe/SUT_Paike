package cn.day1.controller;

import cn.day1.common.AccountProfile;
import cn.day1.common.Result;
import cn.day1.entity.WeixinUser;
import cn.day1.service.WeixinUserService;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.ImmutableMap;
import cn.day1.shiro.LoginUser;
import cn.day1.shiro.jwt.JwtToken;
import cn.day1.utils.TokenUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
public class LoginController {

    @Autowired
    private WeixinUserService userService;


    @Autowired
    private TokenUtil tokenUtil;


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @PostMapping("/login")
    public Result login(@RequestBody LoginUser loginUser, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();

        String userAccount = loginUser.getUserAccount();
        String password = loginUser.getPassword();

        // 验证用户名和 密码
        WeixinUser user = userService.getUserInfoByAccount(userAccount);


        if (user == null) {
            return Result.fail("用户不存在 ！");
        }

        if ( ! user.getUserpasswd().equals(password) || ! user.getUseraccount().equals(userAccount)) {
            return Result.fail("账号或者密码错误 ！");
        }

        // 验证用户名密码成功后生成token
        String token = tokenUtil.generateToken(userAccount);

        // 构建JwtToken
        JwtToken jwtToken = JwtToken.builder().token(token).principal(userAccount).build();

        Subject subject = SecurityUtils.getSubject();

        try {
            // 该方法会调用JwtRealm中的doGetAuthenticationInfo方法
            subject.login(jwtToken);

        } catch (UnknownAccountException exception) {
            exception.printStackTrace();
            System.out.println("账号不存在");

        } catch (IncorrectCredentialsException exception) {
            exception.printStackTrace();
            return Result.fail("错误的凭证，用户名或密码不正确");

        } catch (LockedAccountException exception) {
            exception.printStackTrace();
            return Result.fail("账户已锁定,联系管理员");

        } catch (ExcessiveAttemptsException exception) {
            exception.printStackTrace();
            return Result.fail("错误次数过多");

        } catch (AuthenticationException exception) {
            exception.printStackTrace();
            System.out.println("认证失败");
        }

        // 认证通过
        if(subject.isAuthenticated()){

            // 将token写出到cookie
            Cookie cookie = new Cookie("token",token);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600 * 5);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.flushBuffer();

            AccountProfile userVo = new AccountProfile();
            BeanUtils.copyProperties(user, userVo);
            return Result.succ("登陆成功", userVo);
        }else{

            return Result.fail("登陆失败 ！");
        }
    }


    /**
     * 检查是否登录
     * @param token
     * @return
     */
    @GetMapping(value = "/checkLogin")
    public Object checkLogin(@CookieValue("token") String token){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",200);
        if(StringUtils.isEmpty(token)){
            jsonObject.put("msg","令牌为空");
        }

        // 检查token合法性及用户身份
        return jsonObject;
    }


    /**
     * 登出
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/logout")
    @RequiresAuthentication
    public Result logout(HttpServletRequest request,HttpServletResponse response) throws IOException {

        Optional<Cookie> cookie = Arrays.stream(request.getCookies())
                .filter(ck -> "token".equals(ck.getName()))
                .limit(1)
                .map(ck -> {
                    ck.setMaxAge(0);
                    ck.setHttpOnly(true);
                    ck.setPath("/");
                    return ck;
                })
                .findFirst();
        response.addCookie(cookie.get());
        response.flushBuffer();

        return Result.succ("退出登陆");
    }


    /**
     * 更新token
     * @param token
     * @return
     */
    @PostMapping("/token/refresh")
    public Object refreshToken(@CookieValue(value = "token") String token) {
        JSONObject jsonObject = new JSONObject();
        String newToken = tokenUtil.refreshToken(token);
        jsonObject.put("code",200);
        jsonObject.put("msg","success");
        jsonObject.put("token",newToken);
        jsonObject.put("timestamp", Calendar.getInstance().getTimeInMillis());
        return jsonObject;
    }
}
