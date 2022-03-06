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
@TableName("WEIXIN_GGJXZL")
public class WeixinGgjxzl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学年学期号
     */
    @TableField("XNXQH")
    private String xnxqh;

    /**
     * 起始周次
     */
    @TableField("QSZC")
    private BigDecimal qszc;

    /**
     * 结束周次
     */
    @TableField("JSZC")
    private BigDecimal jszc;

    /**
     * 起始日期
     */
    @TableField("QSRQ")
    private String qsrq;


}
