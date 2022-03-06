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
@TableName("WEIXIN_XSMD")
public class WeixinXsmd implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @TableField("XH")
    private String xh;

    /**
     * 姓名
     */
    @TableField("XM")
    private String xm;

    /**
     * 姓名拼音
     */
    @TableField("XMPY")
    private String xmpy;

    /**
     * 民族
     */
    @TableField("MZ")
    private String mz;

    /**
     * 性别
     */
    @TableField("XB")
    private String xb;

    /**
     * 身份证件号
     */
    @TableField("SFZJH")
    private String sfzjh;

    /**
     * 出生日期
     */
    @TableField("CSRQ")
    private String csrq;

    /**
     * 培养层次
     */
    @TableField("PYCC")
    private String pycc;

    /**
     * 院校所号
     */
    @TableField("YXSH")
    private String yxsh;

    /**
     * 专业号
     */
    @TableField("ZYH")
    private String zyh;

    /**
     * 班级编号
     */
    @TableField("BJBH")
    private String bjbh;

    /**
     * 入学年份
     */
    @TableField("RXNF")
    private String rxnf;

    /**
     * 入学日期
     */
    @TableField("RXRQ")
    private String rxrq;

    /**
     * 当前所在级
     */
    @TableField("DQSZJ")
    private String dqszj;

    /**
     * 学制
     */
    @TableField("XZ")
    private BigDecimal xz;

    /**
     * 学籍状态码
     */
    @TableField("XJZT")
    private String xjzt;

    /**
     * 学籍状态名称
     */
    @TableField("XJZTMC")
    private String xjztmc;


}
