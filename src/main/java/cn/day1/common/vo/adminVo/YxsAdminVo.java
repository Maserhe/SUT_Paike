package cn.day1.common.vo.adminVo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/5/23 15:18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YxsAdminVo implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    private String useraccount;


    /**
     * 院系所号
     */
    private String yxsh;

    /**
     * 真实姓名
     */
    private String userrealname;

    /**
     * 0禁用1启用
     */
    private String userenable;
}
