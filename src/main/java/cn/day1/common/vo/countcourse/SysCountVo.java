package cn.day1.common.vo.countcourse;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/5/24 16:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysCountVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实验室号
     */
    @TableId("SYSH")
    private String sysh;

    /**
     * 实验室名称
     */
    private String sysmc;

    /**
     * 实验室门牌号
     */
    private String sysmph;

    /**
     * 院系所号
     */
    private String yxsh;

    /**
     * 院系所名称
     */
    private String yxmc;

    /**
     * 实验室的 类型。0 开放， 1， 禁用， 2， 故障保修
     */
    private String systype;

    /**
     * 实验室的 容量
     */
    private String capacity;

    /**
     * 实验室的故障信息
     */
    private String info;

    /**
     * 课程数量
     */
    private String sum;
}
