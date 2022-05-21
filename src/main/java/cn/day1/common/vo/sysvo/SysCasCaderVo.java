package cn.day1.common.vo.sysvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/5/21 12:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysCasCaderVo {

    private String label;

    private String value;

    private List<SysCasCaderVo> children;

}
