package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.entity.WeixinBjmc;
import cn.day1.service.WeixinBjmcService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/weixin-bjmc")
public class WeixinBjmcController {


    @Autowired
    private WeixinBjmcService bjmcService;

    /**
     * 根据专业号 获取班级列表 Redis
     * @param ZyId
     * @return
     */
    @PostMapping("/getBjListByZyId")
    public Result  getBjListByZyId(String ZyId) {
        Assert.notNull(ZyId, "参数错误");
        List<WeixinBjmc> data = bjmcService.list(new QueryWrapper<WeixinBjmc>().eq("ZPBH", ZyId));
        return Result.succ("获取成功", data);
    }

    /**
     * 跟酒专业Id 获取入学年份 Redis
     * @param ZyId
     * @return
     */
    @PostMapping("/getRxnfList")
    public Result getBjRxnfByZyId(String ZyId) {
        Assert.notNull(ZyId, "参数错误");
        List<String> rxnfListByZyId = bjmcService.getRxnfListByZyId(ZyId);
        return Result.succ(rxnfListByZyId);
    }

    /**
     * 根据专业id 和 入学年份 获取班级列表
     * @param ZyId
     * @param Rxnf
     * @return
     */
    @PostMapping("/getBjList")
    public Result getBjListByRxnfAndZyId(String ZyId, String Rxnf) {
        Assert.notNull(ZyId, "参数错误");
        Assert.notNull(Rxnf, "参数错误");
        List<WeixinBjmc> list = bjmcService.list(new QueryWrapper<WeixinBjmc>().eq("ZPBH", ZyId).eq("RXNF", Rxnf));
        return Result.succ("获取成功", list);
    }

}
