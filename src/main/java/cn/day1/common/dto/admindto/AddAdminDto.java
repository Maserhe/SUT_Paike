package cn.day1.common.dto.admindto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/5/23 13:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAdminDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String useraccount;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String userpasswd;

    /**
     * 院系所号
     */
    @NotBlank(message = "院系所号不能为空")
    private String yxsh;

    /**
     * 真实姓名
     */
    @NotBlank(message = "真实姓名不能为空")
    private String userrealname;

}
