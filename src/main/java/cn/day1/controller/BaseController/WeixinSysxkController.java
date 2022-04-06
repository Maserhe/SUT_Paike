package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.common.dto.sysdto.AddSysXkDto;
import cn.day1.common.dto.sysdto.GetSysXkTableDto;
import cn.day1.common.vo.jsxkvo.ClassVo;
import cn.day1.common.vo.sysvo.SysXkTableVo;
import cn.day1.entity.WeixinSysxk;
import cn.day1.service.WeixinSysxkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/weixin-sysxk")
public class WeixinSysxkController {

    final private static int DAYNUMBER = 7;

    final private static int SECTIONNUMBER = 5;

    @Autowired
    private WeixinSysxkService sysxkService;

    @PostMapping("/addSysxk")
    public Result addSysXk(@Validated @RequestBody AddSysXkDto addSysXkDto) {
        Assert.notNull(addSysXkDto, "参数错误");
        final List<ClassVo> classList = addSysXkDto.getClassList();
        if (classList == null) {
            return Result.fail("参数错误");
        }
        WeixinSysxk one = sysxkService.getOne(new QueryWrapper<WeixinSysxk>()
                .eq("XNXQ01ID", addSysXkDto.getXnxq01id())
                .eq("KKZC", addSysXkDto.getKkzc())
                .eq("KKSJMX", addSysXkDto.getKksjmx())
                .eq("SYSH", addSysXkDto.getSysh())
        );
        if (one != null ) {
            return Result.fail("实验室已经被安排课程了");
        }
        if (StringUtils.isEmpty(addSysXkDto.getBz())) {
            addSysXkDto.setBz("无");
        }
        List<WeixinSysxk> list = new ArrayList<>(addSysXkDto.getClassList().size());
        classList.forEach(i-> {
            WeixinSysxk sysxk = new WeixinSysxk();
            BeanUtils.copyProperties(addSysXkDto, sysxk);
            sysxk.setBjmc(i.getBjmc());
            sysxk.setJx0404id(i.getBh());
            list.add(sysxk);
        });
        // 先查询 这个时间段没有 排课
        boolean flag = sysxkService.saveBatch(list);
        return flag ? Result.succ("添加成功"): Result.fail("添加失败");
    }

    @PostMapping("/sysxkTable")
    public Result getSysXkTable(@Validated @RequestBody GetSysXkTableDto getSysXkTableDto) {
        Assert.notNull(getSysXkTableDto, "参数错误");
        // 更具参数 查表
        List<WeixinSysxk> list = sysxkService.list(new QueryWrapper<WeixinSysxk>()
                .eq("XNXQ01ID", getSysXkTableDto.getXnxq01id())
                .eq("SYSH", getSysXkTableDto.getSysh())
                .eq("KKZC", getSysXkTableDto.getKkzc()));

        // 数据进行处理
        final List<List<SysXkTableVo>> ans = new ArrayList<>(7);
        for (int i = 0; i < DAYNUMBER; i ++ ) {
            ans.add(new ArrayList<>(5));
        }
        SysXkTableVo[][] res = new SysXkTableVo[DAYNUMBER][SECTIONNUMBER];
        list.forEach(i-> {
            String kksjmx = i.getKksjmx();
            String[] split = kksjmx.split("-");
            // x 周几， y 几节
            int x = Integer.valueOf(split[0]);
            int y =  Integer.valueOf(split[1]);
            if (x > DAYNUMBER || y > SECTIONNUMBER) {
                Result.fail("系统错误,有脏数据");
            }
            if (res[x - 1][y - 1] == null) {
                SysXkTableVo sysXkTableVo = new SysXkTableVo();
                BeanUtils.copyProperties(i, sysXkTableVo);
                sysXkTableVo.setBjmcList(new ArrayList<>(1));

                res[x - 1][y - 1] = sysXkTableVo;
            }
            res[x - 1][y - 1].getBjmcList().add(i.getBjmc());
        });
        return Result.succ(res);
    }







}
