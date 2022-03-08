package cn.day1.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginUserDto {

    private String userAccount;
    private String password;

    private String vcode;
    String vcodeKey;


}
