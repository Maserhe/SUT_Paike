package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.common.constant.StateEnum;
import cn.day1.common.dto.sbdto.AddSbDto;
import cn.day1.common.dto.sbdto.UpdateSbDto;
import cn.day1.entity.WeixinSbzk;
import cn.day1.entity.WeixinSyszk;
import cn.day1.service.WeixinSbzkService;
import cn.day1.service.WeixinSysxkService;
import cn.day1.service.WeixinSyszkService;
import cn.day1.utils.common.UUIDUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    @Autowired
    private WeixinSyszkService syszkService;

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
     * 删除设备
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

    /**
     * 更新设备信息
     * @param sbDto
     * @return
     */
    @RequiresRoles("ADMIN")

    @PostMapping("/updateDevice")
    public Result updateSb(@RequestBody @Validated UpdateSbDto sbDto) {
        Assert.notNull(sbDto, "参数错误");
        // 查询 设备信息
        boolean res = sbzkService.update(new UpdateWrapper<WeixinSbzk>()
                .eq("SBH", sbDto.getSbh())
                .set("SBMC", sbDto.getSbmc())
                .set("SBZT", sbDto.getSbzt())
                .set("INFO", sbDto.getInfo())
        );
        return res? Result.succ("更新成功"): Result.fail("更新失败");
    }

    /**
     *  0 正常， 1 禁用， 2 报修, 修改设备状态
     * @param json
     * @return
     */
    @PostMapping("/repairSb")
    @RequiresAuthentication
    public Result repairSb(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String sbh = map.get("sbh");
        String info = map.get("info");
        String sbzt = map.get("sbzt");

        String sysh = map.get("sysh");

        boolean res = sbzkService.update(new UpdateWrapper<WeixinSbzk>()
                .eq("SBH", sbh)
                .set("SBZT", sbzt)
                .set("INFO", info)
        );

        // 修理好设备
        if (sbzt.equals(String.valueOf(StateEnum.NORAMAL.getType()))) {
            // 如果没有其他需要维修的 设备 ， 并且实验室的 没有非设备信息 维修。 可以更改实验室状态
            WeixinSyszk sys = syszkService.getOne(new QueryWrapper<WeixinSyszk>().eq("SYSH", sysh));
            if (StringUtils.isEmpty(sys.getInfo())) {
                // 查询是否有其他设备报修
                List<WeixinSbzk> list = sbzkService.list(new QueryWrapper<WeixinSbzk>().eq("SYSH", sysh).eq("SBZT", String.valueOf(StateEnum.FAULT.getType())));
                if (list.isEmpty()) {
                    // 实验室设备修改为正常
                    sys.setSystype(String.valueOf(StateEnum.NORAMAL.getType()));
                    syszkService.update(sys, new QueryWrapper<WeixinSyszk>().eq("SYSH", sys.getSysh()));
                }
            }
            return res? Result.succ("设备正常"): Result.fail("设备更改失败");
        // 禁用设备
        } else if(sbzt.equals(String.valueOf(StateEnum.DISABLE.getType()))){
            return res? Result.succ("禁用成功"): Result.fail("禁用失败");
        } else {
            // 将实验室的状态 改为 报修状态
            boolean update = syszkService.update(new UpdateWrapper<WeixinSyszk>()
                    .eq("SYSH", sysh)
                    .set("SYSTYPE", String.valueOf(StateEnum.FAULT.getType())));

            return update & res? Result.succ("申请成功"): Result.fail("申请失败");
        }
    }

    /**
     * 获取 一个 实验室的 所有 需要维修的设备列表
     * @param json
     * @return
     */
    @PostMapping("/sbFaultSbList")
    @RequiresAuthentication
    public Result getFaultSblist(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String sysh = map.get("sysh");
        if (StringUtils.isEmpty(sysh)) {
            return Result.fail("参数错误");
        }
        List<WeixinSbzk> list = sbzkService.list(new QueryWrapper<WeixinSbzk>().eq("SYSH", sysh).eq("SBZT", String.valueOf(StateEnum.FAULT.getType())));
        return Result.succ(list);
    }


}
