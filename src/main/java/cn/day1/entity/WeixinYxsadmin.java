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
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WEIXIN_YXSADMIN")
public class WeixinYxsadmin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    @TableField("USERACCOUNT")
    private String useraccount;

    /**
     * 密码
     */
    @TableField("USERPASSWD")
    private String userpasswd;

    /**
     * 院系所号
     */
    @TableField("YXSH")
    private String yxsh;

    /**
     * 真实姓名
     */
    @TableField("USERREALNAME")
    private String userrealname;

    /**
     * 0禁用1启用
     */
    @TableField("USERENABLE")
    private String userenable;


}
