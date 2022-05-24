package cn.day1.service.impl;

import cn.day1.common.vo.countcourse.SysCountCourse;
import cn.day1.common.vo.countcourse.YxsCountCourse;
import cn.day1.entity.WeixinSysxk;
import cn.day1.mapper.WeixinSysxkMapper;
import cn.day1.mapper.WeixinYxsMapper;
import cn.day1.service.WeixinSysxkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-16
 */
@Service
public class WeixinSysxkServiceImpl extends ServiceImpl<WeixinSysxkMapper, WeixinSysxk> implements WeixinSysxkService {

    @Autowired
    private WeixinSysxkMapper sysxkMapper;

    @Override
    public List<YxsCountCourse> getYxsCountCourseList(String xnxq) {
        return sysxkMapper.getYxsCountCourseList(xnxq);
    }

    @Override
    public List<SysCountCourse> getSysCountCourseList(String xnxq, String sysh) {

        return sysxkMapper.getSysCountCourseList(xnxq, sysh);
    }
}
