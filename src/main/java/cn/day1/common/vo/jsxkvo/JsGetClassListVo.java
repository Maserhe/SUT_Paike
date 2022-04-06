package cn.day1.common.vo.jsxkvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 教师获取 上课的班级 列表
 *
 * @author maserhe
 * @date 2022/4/5 12:16 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsGetClassListVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程名称
     */
    private String kcmc;


    /**
     * 班级列表
     */
    private List<ClassVo> classList = new ArrayList<>(1);


}


