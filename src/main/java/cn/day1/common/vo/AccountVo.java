package cn.day1.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/3/7 1:04 下午
 **/
@Data
public class AccountVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帐号
     */
    private String useraccount;

    /**
     * 真实姓名
     */
    private String userrealname;

    /**
     * 帐号类型 0 系统管理，1 教职工， 2 学生
     */
    private String useraccounttype;

    /**
     * 是否启用该用户1 启用 0 禁用
     */
    private String userenable;


    /**
     * 如果是 二级管理员 改字段 存在
     */
    private String yxsh;


}
