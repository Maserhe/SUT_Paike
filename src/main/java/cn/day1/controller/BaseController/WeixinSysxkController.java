package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.common.dto.sysdto.AddSysXkDto;
import cn.day1.common.dto.sysdto.ChangeSysXkDto;
import cn.day1.common.dto.sysdto.GetSysXkTableDto;
import cn.day1.common.vo.jsxkvo.ClassVo;
import cn.day1.common.vo.sysvo.SysPkListVo;
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

    /**
     * 排课
     * @param addSysXkDto
     * @return
     */
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

    /**
     * 教师 修改实验室 信息
     * @param changeSysXkDto
     * @return
     */
    @PostMapping("/changeXk")
    public Result changeSysXk(@Validated @RequestBody ChangeSysXkDto changeSysXkDto) {
        Assert.notNull(changeSysXkDto, "参数错误");
        final List<ClassVo> classList = changeSysXkDto.getClassList();
        if (classList == null) {
            return Result.fail("参数错误");
        }
        // 查询 这个课程
        QueryWrapper<WeixinSysxk> queryWrapper = new QueryWrapper<WeixinSysxk>()
                .eq("XNXQ01ID", changeSysXkDto.getXnxq01id())
                .eq("KKZC", changeSysXkDto.getKkzc())
                .eq("KKSJMX", changeSysXkDto.getKksjmx())
                .eq("SYSH", changeSysXkDto.getSysh());

        final List<WeixinSysxk> list = sysxkService.list(queryWrapper);
        final boolean remove = sysxkService.remove(queryWrapper);
        if (list == null || list.isEmpty() || !remove) {
            return Result.fail("系统出错，修改失败!");
        }
        // 添加 新的 数据
        if (StringUtils.isEmpty(changeSysXkDto.getBz())) {
            changeSysXkDto.setBz("无");
        }
        List<WeixinSysxk> newSysxk = new ArrayList<>(changeSysXkDto.getClassList().size());
        WeixinSysxk first = list.stream().findFirst().orElse(null);

        classList.forEach(i -> {
            // 需要 first 中 yxsh,
            WeixinSysxk sysxk = new WeixinSysxk();
            BeanUtils.copyProperties(changeSysXkDto, sysxk);
            sysxk.setBjmc(i.getBjmc());
            sysxk.setJx0404id(i.getBh());
            sysxk.setYxsh(first.getYxsh());
            sysxk.setSysmph(first.getSysmph());
            newSysxk.add(sysxk);
        });
        boolean flag = sysxkService.saveBatch(newSysxk);
        return flag ? Result.succ("添加成功"): Result.fail("添加失败");
    }

    /**
     * 查询某一周 排课的课表
     * @param getSysXkTableDto
     * @return
     */
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

        return Result.succ(processXkVo(list));
    }

    /**
     * 根据教工id 和学期号 获取排课的列表
     * @param json
     * @return
     */
    @PostMapping("/Jgpklist")
    public Result getJgpkList(@RequestBody String json) {
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});
        String Xnxq = map.get("Xnxq");
        String JgId = map.get("JgId");
        if (StringUtils.isEmpty(Xnxq) || StringUtils.isEmpty(JgId)) {
            return Result.fail("参数有错");
        }
        List<WeixinSysxk> list = sysxkService.list(new QueryWrapper<WeixinSysxk>()
                .eq("XNXQ01ID", Xnxq)
                .eq("JG0101ID", JgId));
        // 对数据进行加工
        // 根据 实验室号 查询 学院
        Map<String, String> ssmap = new HashMap<>();
        list.forEach(t -> {
            if (! ssmap.containsKey(t.getSysh())) {
                WeixinSyszk sys = syszkService.getOne(new QueryWrapper<WeixinSyszk>().eq("SYSH", t.getSysh()));
                ssmap.put(t.getSysh(), sys.getYxmc());
            }
        });

        List<SysPkListVo> res = new ArrayList<>(list.size());

        // 对同一个选择同一个实验室上课的班级 进行去除重复
        Map<String, SysPkListVo> bjMap = new HashMap<>();
        list.forEach(t-> {

            final String key =t.getXnxq01id() + "&"+  t.getSysh() + "&" + t.getKksjmx() + "&" + t.getKkzc();
            SysPkListVo sysPkListVo = null;

            if (!bjMap.containsKey(key)) {
                sysPkListVo = new SysPkListVo();
                sysPkListVo.setBjmcList(new ArrayList<>());
                bjMap.put(key, sysPkListVo);
                res.add(sysPkListVo);

            }
            sysPkListVo = bjMap.get(key);

            BeanUtils.copyProperties(t, sysPkListVo);
            sysPkListVo.setYxsmc(ssmap.get(t.getSysh()));
            String[] split = t.getKksjmx().split("-");
            if (split.length == 2) {
                sysPkListVo.setKkDay(split[0]);
                sysPkListVo.setKkSection(split[1]);
            }
            sysPkListVo.getBjmcList().add(t.getBjmc());
        });
        Collections.sort(res);

        return Result.succ(res);
    }

    /**
     *  取消某个 选课， 别忘删除 缓存 Redis， 还有 实验室号忘了加了
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
        String sysh = map.get("sysh");

        // 参数判断
        if(StringUtils.isEmpty(xnxq01ID) || StringUtils.isEmpty(kkzc) || StringUtils.isEmpty(kksjmx) || StringUtils.isEmpty(jg0101ID) || StringUtils.isEmpty(sysh)) {
            return Result.fail("参数错误");
        }
        // 删除数据
        boolean res = sysxkService.remove(new QueryWrapper<WeixinSysxk>()
                .eq("XNXQ01ID", xnxq01ID)
                .eq("KKZC", kkzc)
                .eq("KKSJMX", kksjmx)
                .eq("JG0101ID", jg0101ID)
                .eq("SYSH", sysh));
        return res? Result.succ("删除成功"): Result.fail("删除失败");
    }


    private List<SysXkListVo> processXkVo(List<WeixinSysxk> list) {
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
        return res;
    }

}
