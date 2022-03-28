package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.common.dto.sysdto.AddSysDto;
import cn.day1.common.dto.sysdto.SysDto;
import cn.day1.entity.WeixinSyszk;
import cn.day1.service.WeixinSyszkService;
import cn.day1.utils.common.UUIDUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.csvreader.CsvReader;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-16
 */
@RestController
@RequestMapping("/weixin-syszk")
public class WeixinSyszkController {


    @Autowired
    private WeixinSyszkService syszkService;


    /**
     * 根据院系所id获取 实验室 Redis
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Result getSysByYxsId(String id) {
        Assert.notNull(id, "参数错误");
        List<WeixinSyszk> yxsh = syszkService.list(new QueryWrapper<WeixinSyszk>().eq("YXSH", id));
        return Result.succ("获取成功", yxsh);
    }

    /**
     * 根据实验室的id 删除实验室  管理员权限
     * @param id
     * @return
     */
    @PostMapping("/deleteById")
    public Result deleteSysById(String id) {
        Assert.notNull(id, "参数错误");
        final boolean res = syszkService.remove(new QueryWrapper<WeixinSyszk>().eq("SYSH", id));
        return res? Result.succ("删除成功"): Result.fail("删除失败");
    }

    /**
     * 更新实验室的 信息， redis 删除缓存  管理员权限， 删除根据院系所获取得到的实验室列表的缓存， 删除 当前实验室信息的缓存
     * @param sysDto
     * @return
     */
    @PostMapping("/updateSysInfo")
    public Result updateSysInfo(@Validated @RequestBody SysDto sysDto) {
        Assert.notNull(sysDto, "参数错误");
        boolean res = syszkService.update(new UpdateWrapper<WeixinSyszk>()
                .eq("SYSH", sysDto.getSysh())
                .set("SYSMC", sysDto.getSysmc())
                .set("SYSMPH", sysDto.getSysmph()));
        return res? Result.succ("更新成功"): Result.fail("更新失败");
    }

    /**
     * 添加实验室  删除实验室列表的缓存 Redis
     * @param addSysDto
     * @return
     */
    @PostMapping("/addSys")
    public Result addSys(@Validated @RequestBody AddSysDto addSysDto) {
        Assert.notNull(addSysDto, "参数错误");
        // 查询数据库中，当前院系所是否 已经添加了该实验室
        WeixinSyszk one = syszkService.getOne(new QueryWrapper<WeixinSyszk>().eq("SYSMPH", addSysDto.getSysmph()).eq("YXSH", addSysDto.getYxsh()));
        if (one != null) {
            return Result.fail("该实验室已经存在");
        }
        // 如果 实验室名称为空 则设置为默认值
        if (StringUtils.isEmpty(addSysDto.getSysmc())) {
            addSysDto.setSysmc("机房");
        }
        WeixinSyszk sys = new WeixinSyszk();
        BeanUtils.copyProperties(addSysDto, sys);
        sys.setSysh(UUIDUtils.createUUUID());
        // 插入数据库中
        final boolean res = syszkService.save(sys);
        return res? Result.succ("添加成功"): Result.fail("添加失败");
    }



    /**
     * 多余
     * @param file
     * @return
     */
    @PostMapping("/addSYSList")
    public Result addSYS(@RequestParam("file") MultipartFile file, String YxsId, String YxsMc){
        // 处理上传的文件
        Assert.notNull(file, "上传文件不能为空");
        Assert.notNull(YxsId, "参数错误");
        Assert.notNull(YxsMc, "参数错误");

        // 1，判断上传的实验室文件中有没有重复的实验室号
        Set<WeixinSyszk> set = new HashSet<>(1);
        try {
            CsvReader csvReader = new CsvReader(file.getInputStream(), Charset.defaultCharset());
            // 1, 跳过首行
            csvReader.readHeaders();
            // 2, 读取数据
            while (csvReader.readRecord()) {
                String sysName = csvReader.get(0);
                String sysNumber = csvReader.get(1);
                Assert.notNull(sysName, "存在一行,实验室名为空，参数错误");
                Assert.notNull(sysNumber, "存在一行，实验室门牌号为空，参数错误");

                WeixinSyszk syszk = new WeixinSyszk();
                syszk.setSysmc(sysName);
                syszk.setSysmph(sysNumber);
                syszk.setYxsh(YxsId);
                syszk.setYxmc(YxsMc);
                syszk.setSysh(UUIDUtils.createUUUID());

                // 如果实验室存在重复的
                if (set.contains(syszk)) {
                    return Result.fail("存在两行的实验室门牌号相同, 请检查");
                } else {
                    set.add(syszk);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 插入数据库中
        // 查找实验室中是否存在重复的实验室门牌号
        List<WeixinSyszk> list = syszkService.list(new QueryWrapper<WeixinSyszk>().eq("YXSH", YxsId));
        for (int i = 0; i < list.size(); i++) {
            if (set.contains(list.get(i))) {
                return Result.fail("已经存在门牌号为" + list.get(i).getSysmph()+ "的实验室了");
            }
        }

        boolean res = syszkService.saveBatch(set);
        return res? Result.succ("添加成功"): Result.fail("添加失败");
    }


}
