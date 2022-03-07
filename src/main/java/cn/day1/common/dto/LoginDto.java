package cn.day1.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Description:
 *  登陆的dto类
 * @author maserhe
 * @date 2022/3/6 2:57 下午
 **/
@Data
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "昵称不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}

