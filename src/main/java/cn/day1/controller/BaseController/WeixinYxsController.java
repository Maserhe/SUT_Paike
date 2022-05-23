package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.entity.WeixinYxs;
import cn.day1.service.WeixinYxsService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.lang.Assert;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @RequiresAuthentication
    @PostMapping("/yxsById")
    public Result getYxsInfoById(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String id = map.get("id");
        if (StringUtils.isEmpty(id)) {
            return Result.fail("参数错误");
        }
        WeixinYxs dwh = yxsService.getOne(new QueryWrapper<WeixinYxs>().eq("DWH", id));
        return Result.succ(dwh);
    }


}
