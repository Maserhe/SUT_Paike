package cn.day1.service.impl;

import cn.day1.entity.WeixinBjmc;
import cn.day1.mapper.WeixinBjmcMapper;
import cn.day1.service.WeixinBjmcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-06
 */
@Service
public class WeixinBjmcServiceImpl extends ServiceImpl<WeixinBjmcMapper, WeixinBjmc> implements WeixinBjmcService {


    @Autowired
    private WeixinBjmcMapper bjmcMapper;

    /**
     * 获取 入学年份列表
     * @param ZYBH
     * @return
     */
    @Override
    public List<String> getRxnfListByZyId(String ZYBH) {
        return bjmcMapper.getRxnfListByZyId(ZYBH);
    }
}
