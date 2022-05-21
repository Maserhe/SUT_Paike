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
 * @since 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WEIXIN_SBZK")
public class WeixinSbzk implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备号
     */
    @TableField("SBH")
    private String sbh;

    /**
     * 实验室号
     */
    @TableField("SYSH")
    private String sysh;

    /**
     * 设备名称
     */
    @TableField("SBMC")
    private String sbmc;

    /**
     * 设备状态，0正常，1故障
     */
    @TableField("SBZT")
    private String sbzt;

    /**
     *  设备故障信息
     */
    @TableField("INFO")
    private String info;


}
