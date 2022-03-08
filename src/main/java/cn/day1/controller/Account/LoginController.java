package cn.day1.controller.Account;

import cn.day1.common.constant.Constant;
import cn.day1.common.constant.Result;
import cn.day1.entity.WeixinUser;
import cn.day1.service.WeixinUserService;
import cn.day1.utils.common.JedisUtil;
import cn.day1.utils.JwtUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import cn.day1.common.dto.LoginUserDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private WeixinUserService userService;


    @PostMapping("/login")
    public Result login(@RequestBody LoginUserDto loginUserDto, HttpServletResponse response) throws IOException {

        String userAccount = loginUserDto.getUserAccount();
        String password = loginUserDto.getPassword();
        // 验证用户名和 密码
        WeixinUser user = userService.getUserInfoByAccount(userAccount);
        if (user == null) {
            return Result.fail("用户不存在 ！");
        }
        if ( ! user.getUserpasswd().equals(password) || ! user.getUseraccount().equals(userAccount)) {
            return Result.fail("账号或者密码错误 ！");
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
        return Result.succ("登陆成功！");
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



}
