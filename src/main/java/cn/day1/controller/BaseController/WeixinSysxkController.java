package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.common.dto.sysdto.AddSysXkDto;
import cn.day1.common.dto.sysdto.GetSysXkTableDto;
import cn.day1.common.vo.jsxkvo.ClassVo;
import cn.day1.common.vo.sysvo.SysXkListVo;
import cn.day1.common.vo.sysvo.SysXkTableVo;
import cn.day1.entity.WeixinSysxk;
import cn.day1.entity.WeixinSyszk;
import cn.day1.service.WeixinSysxkService;
import cn.day1.service.WeixinSyszkService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
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
@RequestMapping("/weixin-sysxk")
public class WeixinSysxkController {

    final private static int DAYNUMBER = 7;

    final private static int SECTIONNUMBER = 5;

    @Autowired
    private WeixinSysxkService sysxkService;

    @Autowired
    private WeixinSyszkService syszkService;

    @PostMapping("/addSysxk")
    public Result addSysXk(@Validated @RequestBody AddSysXkDto addSysXkDto) {
        Assert.notNull(addSysXkDto, "参数错误");
        final List<ClassVo> classList = addSysXkDto.getClassList();
        if (classList == null) {
            return Result.fail("参数错误");
        }

        List<WeixinSysxk> one = sysxkService.list(new QueryWrapper<WeixinSysxk>()
                .eq("XNXQ01ID", addSysXkDto.getXnxq01id())
                .eq("KKZC", addSysXkDto.getKkzc())
                .eq("KKSJMX", addSysXkDto.getKksjmx())
                .eq("SYSH", addSysXkDto.getSysh())
        );

        if (one != null && one.size() != 0 ) {
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

    /**
     * 根据 学期号 和 班级id 获取某个班级 的实验室排课 情况
     * @param json
     * @return
     */
    @PostMapping("/xklist")
    public Result getSysXkList(@RequestBody String json) {
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String Xnxq = map.get("Xnxq");
        String BjId = map.get("BjId");
        if (StringUtils.isEmpty(Xnxq) || StringUtils.isEmpty(BjId)) {
            return Result.fail("参数有错");
        }
        List<WeixinSysxk> list = sysxkService.list(new QueryWrapper<WeixinSysxk>()
                .eq("XNXQ01ID", Xnxq)
                .eq("JX0404ID", BjId));
        // 根据 实验室号 查询 学院
        Map<String, String> ssmap = new HashMap<>();
        list.forEach(t -> {
            if (! ssmap.containsKey(t.getSysh())) {
                WeixinSyszk sys = syszkService.getOne(new QueryWrapper<WeixinSyszk>().eq("SYSH", t.getSysh()));
                ssmap.put(t.getSysh(), sys.getYxmc());
            }
        });

        // 对 结果 进行排序
        List<SysXkListVo> res = new ArrayList<>(list.size());
        list.stream().forEach(t-> {
            SysXkListVo sysXkListVo = new SysXkListVo();
            BeanUtils.copyProperties(t, sysXkListVo);
            sysXkListVo.setYxsmc(ssmap.get(t.getSysh()));
            String[] split = t.getKksjmx().split("-");
            if (split.length == 2) {
                sysXkListVo.setKkDay(split[0]);
                sysXkListVo.setKkSection(split[1]);
            }
            res.add(sysXkListVo);
        });
        Collections.sort(res);
        return Result.succ(res);
    }

    /**
     *  取消某个 选课， 别忘删除 缓存 Redis
     * @param json
     * @return
     */
    @PostMapping("/cancleXk")
    public Result cancleSysxk(@RequestBody String json) {
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String xnxq01ID = map.get("xnxq01ID");
        String kkzc = map.get("kkzc");
        String kksjmx = map.get("kksjmx");
        String jg0101ID = map.get("jg0101ID");
        // 参数判断
        if(StringUtils.isEmpty(xnxq01ID) || StringUtils.isEmpty(kkzc) || StringUtils.isEmpty(kksjmx) || StringUtils.isEmpty(jg0101ID)) {
            return Result.fail("参数错误");
        }
        // 删除数据
        boolean res = sysxkService.remove(new QueryWrapper<WeixinSysxk>()
                .eq("XNXQ01ID", xnxq01ID).eq("KKZC", kkzc).eq("KKSJMX", kksjmx).eq("JG0101ID", jg0101ID));
        return res? Result.succ("删除成功"): Result.fail("删除失败");
    }




}
