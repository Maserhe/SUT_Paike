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
import java.util.List;

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
    public Result addSYS(@RequestParam("file") MultipartFile file){
        // 处理上传的文件
        Assert.notNull(file, "上传文件不能为空");
        boolean flag = true;
        try {
            CsvReader csvReader = new CsvReader(file.getInputStream(), Charset.defaultCharset());
            // 1, 跳过首行
            csvReader.readHeaders();
            // 2, 读取数据
            while (csvReader.readRecord()) {

                String classNumber = csvReader.get(0);
                String username = csvReader.get(1);
                String name = csvReader.get(2);
                String password = csvReader.get(3);
                Assert.notNull(username, "学号为空");
                Assert.notNull(name, "姓名为空");
                Assert.notNull(password, "密码为空");
                Assert.notNull(classNumber, "班号不能为空");

                // 3, 数据写入
                // 4, 添加实验室。
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.succ("添加实验室成功", flag);
    }


}
