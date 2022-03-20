package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.entity.WeixinSyszk;
import cn.day1.service.WeixinSyszkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csvreader.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
