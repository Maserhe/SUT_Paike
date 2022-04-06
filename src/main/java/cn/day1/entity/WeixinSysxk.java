package cn.day1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WEIXIN_SYSXK")
public class WeixinSysxk implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程教学班编号
     */
    @TableField("JX0404ID")
    private String jx0404id;

    /**
     * 学年学期
     */
    @TableField("XNXQ01ID")
    private String xnxq01id;

    /**
     * 排课周次
     */
    @TableField("KKZC")
    private String kkzc;

    /**
     * 排课时间明细
     */
    @TableField("KKSJMX")
    private String kksjmx;

    /**
     * 课程名称
     */
    @TableField("KCMC")
    private String kcmc;

    /**
     * 教工名称
     */
    @TableField("JGMC")
    private String jgmc;

    /**
     * 实验室号
     */
    @TableField("SYSH")
    private String sysh;

    /**
     * 实验室门牌号
     */
    @TableField("SYSMPH")
    private String sysmph;

    /**
     * 实验室所在的院系所名称
     */
    @TableField("YXSH")
    private String yxsh;

    /**
     * 排课的备注说明
     */
    @TableField("BZ")
    private String bz;

    /**
     * 教工id
     */
    @TableField("JG0101ID")
    private String jg0101id;

    /**
     * 班级名称
     */
    @TableField("BJMC")
    private String bjmc;


}
