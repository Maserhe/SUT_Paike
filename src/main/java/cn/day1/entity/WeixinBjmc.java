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
@TableName("WEIXIN_BJMC")
public class WeixinBjmc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班号（名）,班级编号
     */
    @TableField("BH")
    private String bh;

    /**
     * 班级名称
     */
    @TableField("BJ")
    private String bj;

    /**
     * 班级实际人数
     */
    @TableField("BJRSSJ")
    private BigDecimal bjrssj;

    /**
     * 所属单位,所属学院
     */
    @TableField("XX0301ID")
    private String xx0301id;

    /**
     * 专业编号
     */
    @TableField("ZPBH")
    private String zpbh;

    /**
     * 入学年份,入学年份
     */
    @TableField("RXNF")
    private String rxnf;


}
