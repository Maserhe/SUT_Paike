package cn.day1.common.vo.sysvo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * 实验室选课的vo类
 *
 * @author maserhe
 * @date 2022/4/4 11:07 上午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysXkTableVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级名称
     */
    private List<String> bjmcList;

    /**
     * 课程名称
     */
    private String kcmc;


    /**
     * 教工名称
     */
    private String jgmc;


    /**
     * 实验室门牌号
     */
    private String sysmph;


    /**
     * 排课的备注说明
     */
    private String bz;

}
