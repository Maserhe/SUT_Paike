package cn.day1.entity;

import java.math.BigDecimal;
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
 * @since 2022-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WEIXIN_XSKB")
public class WeixinXskb implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程教学班编号
     */
    @TableField("JX0404ID")
    private String jx0404id;

    /**
     * 学年学期,学年学期
     */
    @TableField("XNXQ01ID")
    private String xnxq01id;

    /**
     * 学生学号
     */
    @TableField("XS0101ID")
    private BigDecimal xs0101id;

    /**
     * 单双周标志,0 全部 1 单周 2双周
     */
    @TableField("SJBZ")
    private String sjbz;

    /**
     * 开课周次
     */
    @TableField("KKZC")
    private String kkzc;

    /**
     * 开课周次明细
     */
    @TableField("KKZCMX")
    private String kkzcmx;

    /**
     * 排课时间
     */
    @TableField("KCSJ")
    private String kcsj;

    /**
     * 排课时间明细
     */
    @TableField("KCSJMX")
    private String kcsjmx;

    /**
     * 教室名称
     */
    @TableField("JX0601MC")
    private String jx0601mc;

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
     * 课程编号
     */
    @TableField("KCH")
    private String kch;

    /**
     * 教学班名称
     */
    @TableField("KTMC")
    private String ktmc;


}
