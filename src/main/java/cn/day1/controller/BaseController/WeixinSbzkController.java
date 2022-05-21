package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.common.dto.sbdto.AddSbDto;
import cn.day1.entity.WeixinSbzk;
import cn.day1.service.WeixinSbzkService;
import cn.day1.utils.common.UUIDUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.lang.Assert;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maserhe
 * @since 2022-05-21
 */
@RestController
@RequestMapping("/weixin-sbzk")
public class WeixinSbzkController {

    @Autowired
    private WeixinSbzkService sbzkService;

    @RequiresRoles("ADMIN")
    @PostMapping("/addDevice")
    public Result addSb(@RequestBody @Validated AddSbDto addSbDto) {
        Assert.notNull(addSbDto, "参数错误");
        WeixinSbzk sb = new WeixinSbzk();
        BeanUtils.copyProperties(addSbDto, sb);
        // 生成 设备的 号
        sb.setSbh(UUIDUtils.createUUUID());
        boolean res = sbzkService.save(sb);
        return res? Result.succ("添加成功"): Result.fail("添加失败");
    }

    /**
     * 获取 某个实验室的 所有设备
     * @param json
     * @return
     */
    @RequiresAuthentication
    @PostMapping("/deviceList")
    public Result getSbList(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String id = map.get("sysh");
        if (StringUtils.isEmpty(id)) {
            return Result.fail("参数错误");
        }
        List<WeixinSbzk> list = sbzkService.list(new QueryWrapper<WeixinSbzk>().eq("SYSH", id));
        return Result.succ(list);
    }

    /**
     * 删除涉笔
     * @param json
     * @return
     */
    @RequiresRoles("ADMIN")
    @PostMapping("/deleteDevice")
    public Result deleteSb(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String id = map.get("sbh");
        if (StringUtils.isEmpty(id)) {
            return Result.fail("参数错误");
        }
        boolean res = sbzkService.remove(new QueryWrapper<WeixinSbzk>().eq("SBH", id));
        return res? Result.succ("删除成功"): Result.fail("删除失败");
    }


}
