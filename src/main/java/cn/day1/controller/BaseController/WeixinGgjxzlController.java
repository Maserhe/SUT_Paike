package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.entity.WeixinGgjxzl;
import cn.day1.service.WeixinGgjxzlService;
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
@RequestMapping("/weixin-ggjxzl")
public class WeixinGgjxzlController {

    @Autowired
    private WeixinGgjxzlService ggjxzlService;


    /**
     *  权限控制， redis,  获取所有学年学期列表。
     *
     * @return
     */
    @GetMapping("/getXnxqList")
    public Result getXnxqList() {
        List<WeixinGgjxzl> list = ggjxzlService.list();
        return Result.succ("获取成功", list);
    }


}
