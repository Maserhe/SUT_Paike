package cn.day1.common.vo;

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

    private String accessToken;

    /**
     *  过期时间
     */
    private int expires;

    private String name;

}
