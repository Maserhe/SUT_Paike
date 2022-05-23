package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.common.dto.admindto.AddAdminDto;
import cn.day1.common.vo.adminVo.YxsAdminVo;
import cn.day1.entity.WeixinYxsadmin;
import cn.day1.service.WeixinYxsadminService;
import com.alibaba.druid.util.Utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.lang.Assert;
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
import java.util.stream.Stream;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maserhe
 * @since 2022-05-23
 */
@RestController
@RequestMapping("/weixin-yxsadmin")
public class WeixinYxsadminController {


    @Autowired
    private WeixinYxsadminService yxsadminService;

    /**
     * 添加管理员
     * @param adminDto
     * @return
     */
    @RequiresRoles("ADMIN")
    @PostMapping("/addAdmin")
    public Result addAdmin(@RequestBody @Validated AddAdminDto adminDto) {
        Assert.notNull(adminDto, "参数错误");
        // 查询是否数据库中是否 已经存在该字段
        WeixinYxsadmin one = yxsadminService.getOne(new QueryWrapper<WeixinYxsadmin>().eq("USERACCOUNT", adminDto.getUseraccount()));
        if (one != null) {
            return Result.fail("该二级管理员账号已经存在");
        }
        // 插入数据中
        String passwd = Utils.md5(adminDto.getUserpasswd());
        WeixinYxsadmin newAdmin = new WeixinYxsadmin();
        BeanUtils.copyProperties(adminDto, newAdmin);

        newAdmin.setUserpasswd(passwd);
        // 1, 表示启用， 2表示禁用
        newAdmin.setUserenable("1");
        boolean res = yxsadminService.save(newAdmin);
        return res? Result.succ("添加成功"): Result.fail("添加失败");
    }

    /**
     * 删除 二级管理员
     * @param json
     * @return
     */
    @RequiresRoles("ADMIN")
    @PostMapping("/delAdmin")
    public Result deleteAdmin(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String id = map.get("account");
        if (StringUtils.isEmpty(id)) {
            return Result.fail("参数错误");
        }
        boolean res = yxsadminService.remove(new QueryWrapper<WeixinYxsadmin>().eq("USERACCOUNT", id));
        return res? Result.succ("删除成功"): Result.fail("删除失败");
    }

    /**
     * 修改二级管理员状态
     * @param json
     * @return
     */
    @RequiresRoles("ADMIN")
    @PostMapping("/changeState")
    public Result changeAdminState(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String id = map.get("account");
        String state = map.get("state");
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(state)) {
            return Result.fail("参数错误");
        }
        if (state.equals("0") || state.equals("1")) {
            boolean res = yxsadminService.update(new UpdateWrapper<WeixinYxsadmin>().eq("USERACCOUNT", id).set("USERENABLE", state));
            return res? Result.succ("更新成功"): Result.fail("更新失败");
        } else {
            return Result.fail("参数错误");
        }
    }


    /**
     *  查询某个学院的 二级管理员
     * @param json
     * @return
     */
    @RequiresRoles("ADMIN")
    @PostMapping("/yxsAdminlist")
    public Result getYxsAdminById(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String id = map.get("yxsh");
        if (StringUtils.isEmpty(id)) {
            return Result.fail("参数错误");
        }
        // 获取二级管理员 列表
        List<WeixinYxsadmin> list = yxsadminService.list(new QueryWrapper<WeixinYxsadmin>().eq("YXSH", id));

        Stream<YxsAdminVo> yxsAdminVoStream = list.stream().map(t -> {
            YxsAdminVo yxsAdminVo = new YxsAdminVo();
            BeanUtils.copyProperties(t, yxsAdminVo);
            return yxsAdminVo;
        });
        return Result.succ(yxsAdminVoStream);
    }


    /**
     *  获取 所有的 二级管理员 列表
     * @return
     */
    @RequiresRoles("ADMIN")
    @PostMapping("/adminlist")
    public Result adminList() {
        List<WeixinYxsadmin> list = yxsadminService.list();
        Stream<YxsAdminVo> yxsAdminVoStream = list.stream().map(t -> {
            YxsAdminVo yxsAdminVo = new YxsAdminVo();
            BeanUtils.copyProperties(t, yxsAdminVo);
            return yxsAdminVo;
        });
        return Result.succ(yxsAdminVoStream);
    }
}
