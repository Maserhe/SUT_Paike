package cn.day1.controller.Account;

import cn.day1.common.constant.Constant;
import cn.day1.common.constant.Result;
import cn.day1.common.vo.AccountVo;
import cn.day1.entity.WeixinUser;
import cn.day1.entity.WeixinYxsadmin;
import cn.day1.service.WeixinUserService;
import cn.day1.service.WeixinYxsadminService;
import cn.day1.utils.common.JedisUtil;
import cn.day1.utils.JwtUtil;
import cn.day1.common.dto.LoginUserDto;
import com.alibaba.druid.util.Utils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxytiandi.encrypt.springboot.annotation.Encrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {

    /**
     * RefreshToken过期时间
     */
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;

    @Value("${accessTokenExpireTime}")
    private String accessTokenExpireTime;

    @Autowired
    private WeixinUserService userService;

    @Autowired
    private WeixinYxsadminService yxsadminService;


    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginUserDto loginUserDto, HttpServletResponse response) throws IOException {

        String userAccount = loginUserDto.getUsername();
        String password = Utils.md5(loginUserDto.getPassword());

        // 验证用户名和 密码
        WeixinUser user = userService.getUserInfoByAccount(userAccount);
        if (user == null) {
            return Result.fail("用户不存在 ！");
        }
        if ( ! user.getUserpasswd().equals(password) || ! user.getUseraccount().equals(userAccount)) {
            return Result.fail("账号或者密码错误 ！");
        }

        if ("0".equals(user.getUserenable())) {
            return Result.fail("账号被禁用");
        }

        // 清除可能存在的Shiro权限信息缓存
        if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + userAccount)) {
            JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + userAccount);
        }
        // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());

        JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userAccount, currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));

        // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
        String token = JwtUtil.sign(userAccount, currentTimeMillis);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");

        AccountVo vo = new AccountVo();
        BeanUtils.copyProperties(user, vo);
        if (vo.getUseraccounttype().equals("3")) {
            WeixinYxsadmin temp = yxsadminService.getOne(new QueryWrapper<WeixinYxsadmin>().eq("USERACCOUNT", user.getUseraccount()));
            vo.setYxsh(temp.getYxsh());
        }

        return Result.succ("登陆成功！", vo);
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
    public Result logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String token = request.getHeader("Authorization");
        String account = JwtUtil.getClaim(token, Constant.ACCOUNT);
        JedisUtil.delKey(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account);
        SecurityUtils.getSubject().logout();

        return Result.succ("退出登陆");
    }

    @GetMapping(value = "/getAsyncRoutes")
    @RequiresAuthentication
    public Result getAsyncRoutes(String name) {
        WeixinUser user = userService.getUserInfoByAccount(name);
        String type = user.getUseraccounttype();
        String role = "";
        if (type.equals("0") || type.equals("3")) {
            role = "admin";
        } else if (type.equals("1")){
            role = "teacher";
        } else {
            role = "student";
        }
        return Result.succ(role);
    }


}
