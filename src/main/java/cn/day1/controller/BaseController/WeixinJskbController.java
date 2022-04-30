package cn.day1.controller.BaseController;


import cn.day1.common.constant.Result;
import cn.day1.common.vo.jsxkvo.ClassVo;
import cn.day1.common.vo.jsxkvo.JsGetClassListVo;
import cn.day1.entity.WeixinJskb;
import cn.day1.service.WeixinJskbService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.lang.Assert;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/weixin-jskb")
public class WeixinJskbController {

    @Autowired
    private WeixinJskbService jskbService;

    /**
     * 根据 学期学年号, 教工号 获取 课程列表 和 班级列表。KTMC
     * @param json
     * @return
     */
    @PostMapping("/getjskb")
    @RequiresAuthentication
    public Result getJskb(@RequestBody String json) {
        // 解析字符串
        Assert.notNull(json, "参数错误");
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>() {});

        String xnxqh = map.get("Xnxqh");
        String jgh = map.get("Jgh");
        if (StringUtils.isEmpty(xnxqh) || StringUtils.isEmpty(jgh)) {
           return Result.fail("参数错误");
        }

        List<JsGetClassListVo> ans = new ArrayList<>(1);
        Map<String, Map<String, String>> res = new HashMap<>(1);
        List<WeixinJskb> list = jskbService.list(new QueryWrapper<WeixinJskb>().eq("XNXQ01ID", xnxqh).eq("JG0101ID", jgh));

        // 根据list 处理
        list.stream().forEach(t -> {
            String kcmc = t.getKcmc();
            JsGetClassListVo temp = null;

            for (int i = 0; i < ans.size(); i++) {
                if (ans.get(i).getKcmc().equals(kcmc)) {
                    temp = ans.get(i);
                    break;
                }
            }
            // 不存在则创建
            if (temp == null) {
                temp = new JsGetClassListVo();
                temp.setKcmc(kcmc);
                ans.add(temp);
            }
            ClassVo classVo = new ClassVo();
            classVo.setBh(t.getJx0404id());
            classVo.setBjmc(t.getKtmc());

            temp.getClassList().add(classVo);
        });

        return Result.succ("获取成功", ans);
    }


}
