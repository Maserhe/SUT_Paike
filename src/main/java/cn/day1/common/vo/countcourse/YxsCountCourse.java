package cn.day1.common.vo.countcourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/5/24 15:15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YxsCountCourse  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dwh;

    private String sum;


}
