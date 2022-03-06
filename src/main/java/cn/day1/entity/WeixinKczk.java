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
@TableName("WEIXIN_KCZK")
public class WeixinKczk implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程编码,课程及活动的编号，学校
     */
    @TableField("KCH")
    private String kch;

    /**
     * 课程名称,课程中文名称
     */
    @TableField("KCMC")
    private String kcmc;

    /**
     * 课程英文名称,课程英文名称
     */
    @TableField("KCYWMC")
    private String kcywmc;


}
