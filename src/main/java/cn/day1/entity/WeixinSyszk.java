package cn.day1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Objects;

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
@TableName("WEIXIN_SYSZK")
public class WeixinSyszk implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实验室号
     */
    @TableId("SYSH")
    private String sysh;

    /**
     * 实验室名称
     */
    @TableField("SYSMC")
    private String sysmc;

    /**
     * 实验室门牌号
     */
    @TableField("SYSMPH")
    private String sysmph;

    /**
     * 院系所号
     */
    @TableField("YXSH")
    private String yxsh;

    /**
     * 院系所名称
     */
    @TableField("YXMC")
    private String yxmc;

    /**
     * 实验室的 类型。0 开放， 1， 禁用， 2， 故障保修
     */
    @TableField("SYSTYPE")
    private String systype;

    /**
     * 实验室的 容量
     */
    @TableField("CAPACITY")
    private String capacity;

    /**
     * 实验室的故障信息
     */
    @TableField("INFO")
    private String info;




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WeixinSyszk syszk = (WeixinSyszk) o;
        return sysmph.equals(syszk.sysmph) && yxsh.equals(syszk.yxsh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysmph, yxsh);
    }
}
