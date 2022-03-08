package cn.day1.config.shiro;

import cn.day1.common.constant.Constant;
import cn.day1.common.constant.RoleEnum;
import cn.day1.common.exception.CustomUnauthorizedException;
import cn.day1.config.shiro.jwt.JwtToken;
import cn.day1.entity.WeixinUser;
import cn.day1.service.WeixinUserService;
import cn.day1.utils.common.JedisUtil;
import cn.day1.utils.JwtUtil;
import cn.day1.utils.common.StringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Description:
 *
 * @author maserhe
 * @date 2022/3/8 9:00 上午
 **/
@Service
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private WeixinUserService userService;

    /**
     * 大坑，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        String account = JwtUtil.getClaim(principalCollection.toString(), Constant.ACCOUNT);
        WeixinUser user = verifyUser(account);

        // 分配 身份
        final String type = user.getUseraccounttype();
        String role = "";
        switch (type) {
            case "0":
                role = RoleEnum.ADMIN.name();
                break;
            case "1":
                role = RoleEnum.TEACHER.name();
                break;
            case "2":
                role = RoleEnum.STUDENT.name();
                break;
        }

        simpleAuthorizationInfo.addRole(role);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得account，用于和数据库进行对比
        String account = JwtUtil.getClaim(token, Constant.ACCOUNT);

        WeixinUser user = verifyUser(account);

        // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
        if (JwtUtil.verify(token) && JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account)) {
            // 获取RefreshToken的时间戳
            String currentTimeMillisRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
            // 获取AccessToken时间戳，与RefreshToken的时间戳对比
            if (JwtUtil.getClaim(token, Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
                return new SimpleAuthenticationInfo(token, token, "userRealm");
            }
        }
        throw new AuthenticationException("Token已过期!");
    }


    private WeixinUser verifyUser(String account) {

        // 帐号为空
        if (StringUtil.isBlank(account)) {
            throw new AuthenticationException("Token中帐号为空!");
        }
        // 查询用户是否存在
        WeixinUser user = userService.getUserInfoByAccount(account);

        if (user == null) {
            throw new AuthenticationException("该帐号不存在!");
        }

        if ("0".equals(user.getUserenable())) {
            throw new CustomUnauthorizedException("该账号已经被禁用!");
        }
        return user;
    }
}
