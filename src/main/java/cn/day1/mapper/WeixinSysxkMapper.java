package cn.day1.mapper;

import cn.day1.common.vo.countcourse.SysCountCourse;
import cn.day1.common.vo.countcourse.YxsCountCourse;
import cn.day1.entity.WeixinSysxk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-16
 */
@Mapper
public interface WeixinSysxkMapper extends BaseMapper<WeixinSysxk> {



    List<YxsCountCourse> getYxsCountCourseList(String xnxq);

    List<SysCountCourse> getSysCountCourseList(String xnxq, String yxsh);



}
