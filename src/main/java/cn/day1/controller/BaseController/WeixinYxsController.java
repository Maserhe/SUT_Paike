package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.entity.WeixinYxs;
import cn.day1.service.WeixinYxsService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/weixin-yxs")
public class WeixinYxsController {



    @Autowired
    private WeixinYxsService yxsService;

    /**
     * 查找学院信息， 所有登陆用户都可查询 redis
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/getAllYxs")
    public Result getAllYxsInfo() {
        List<WeixinYxs> list = yxsService.list();
        return Result.succ("获取成功", list);
    }


}
