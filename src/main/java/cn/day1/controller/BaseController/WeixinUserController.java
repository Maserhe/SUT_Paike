package cn.day1.controller.BaseController;


import cn.day1.entity.WeixinUser;
import cn.day1.service.WeixinUserService;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/weixin-user")
public class WeixinUserController {


    @Autowired
    private WeixinUserService weixinUserService;

    @RequestMapping("/user")
    @RequiresAuthentication
    public String getUserInfo(String username) {

        WeixinUser user = weixinUserService.getOne(new QueryWrapper<WeixinUser>().eq("USERACCOUNT", username));
        return JSONUtil.toJsonStr(user);
    }




}
