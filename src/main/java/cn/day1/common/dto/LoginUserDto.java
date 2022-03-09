package cn.day1.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginUserDto {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull(message = "不能为空")
    private String password;

    private String vcode;
    String vcodeKey;


}
