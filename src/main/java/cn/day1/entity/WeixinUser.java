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
@TableName("WEIXIN_USER")
public class WeixinUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 密码
     */
    @TableField("USERPASSWD")
    private String userpasswd;

    /**
     * 帐号
     */
    @TableField("USERACCOUNT")
    private String useraccount;

    /**
     * 真实姓名
     */
    @TableField("USERREALNAME")
    private String userrealname;

    /**
     * 帐号类型 0 系统管理，1 教职工， 2 学生
     */
    @TableField("USERACCOUNTTYPE")
    private String useraccounttype;

    /**
     * 是否启用该用户1启用0禁用
     */
    @TableField("USERENABLE")
    private String userenable;


}
