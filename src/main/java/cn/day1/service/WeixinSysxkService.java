package cn.day1.service;

import cn.day1.common.vo.countcourse.SysCountCourse;
import cn.day1.common.vo.countcourse.YxsCountCourse;
import cn.day1.entity.WeixinSysxk;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-16
 */
public interface WeixinSysxkService extends IService<WeixinSysxk> {

    List<YxsCountCourse> getYxsCountCourseList(String xnxq);

    List<SysCountCourse> getSysCountCourseList(String xnxq, String yxsh);

}
