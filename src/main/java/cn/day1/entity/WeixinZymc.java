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
@TableName("WEIXIN_ZYMC")
public class WeixinZymc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专业号，专业号（专业代码，含大类）
     */
    @TableField("ZYH")
    private String zyh;

    /**
     * 专业名称,专业名称
     */
    @TableField("ZYMC")
    private String zymc;

    /**
     * 专业简称
     */
    @TableField("ZYJC")
    private String zyjc;

    /**
     * 专业英文名称
     */
    @TableField("ZYYWMC")
    private String zyywmc;

    /**
     * 所属院系,专业所属的院系所编号。各校自编,XX0301ID
     */
    @TableField("YXSH")
    private String yxsh;

    /**
     * 学制,字典表，可能是四年制、也可能是五年制等。
     */
    @TableField("XZ")
    private BigDecimal xz;


}
