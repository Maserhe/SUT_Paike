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
@TableName("WEIXIN_YXS")
public class WeixinYxs implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单位号,单位编码
     */
    @TableField("DWH")
    private String dwh;

    /**
     * 单位名称
     */
    @TableField("DWMC")
    private String dwmc;

    /**
     * 单位英文名称,单位英文名称
     */
    @TableField("DWYWMC")
    private String dwywmc;

    /**
     * 单位简称,单位简称
     */
    @TableField("DWJC")
    private String dwjc;


}
