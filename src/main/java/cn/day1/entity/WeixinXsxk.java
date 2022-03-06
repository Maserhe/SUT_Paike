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
 * @since 2022-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WEIXIN_XSXK")
public class WeixinXsxk implements Serializable {

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
    private String xs0101id;

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

    /**
     * 教师姓名
     */
    @TableField("JSXM")
    private String jsxm;

    /**
     * 章节内容
     */
    @TableField("ZJNR")
    private String zjnr;

    /**
     * 教工名称
     */
    @TableField("KCMC")
    private String kcmc;


}
