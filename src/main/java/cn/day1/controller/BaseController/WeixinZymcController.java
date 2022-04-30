package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.entity.WeixinZymc;
import cn.day1.service.WeixinZymcService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/weixin-zymc")
public class WeixinZymcController {


    @Autowired
    private WeixinZymcService zymcService;

    /**
     * 根据 院系所号 获取专业列表 Redis
     * @param YxsId
     * @return
     */
    @PostMapping("/getZyList")
    @RequiresAuthentication
    public Result getZyListByYxsId(String YxsId) {
        Assert.notNull(YxsId, "参数错误");
        List<WeixinZymc> data = zymcService.list(new QueryWrapper<WeixinZymc>().eq("YXSH", YxsId));
        return Result.succ("获取成功", data);
    }




}
