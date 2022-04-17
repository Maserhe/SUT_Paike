package cn.day1.common.dto.sysdto;

import cn.day1.common.vo.jsxkvo.ClassVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/4/17 7:59 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeSysXkDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级 列表
     */
    @NotNull(message = "参数错误")
    private List<ClassVo> classList;

    /**
     * 学年学期
     */
    @NotBlank(message = "学期号不能为空")
    private String xnxq01id;

    /**
     * 实验室号
     */
    @NotBlank(message = "实验室号不能为空")
    private String sysh;

    /**
     * 排课周次
     */
    @NotBlank(message = "周次号不能为空")
    private String kkzc;

    /**
     * 排课时间明细
     */
    @NotBlank(message = "排课时间不能为空")
    private String kksjmx;

    /**
     * 课程名称
     */
    @NotBlank(message = "课程名称不能为空")
    private String kcmc;


    /**
     * 教工id
     */
    @NotBlank(message = "教工id不能为空")
    private String jg0101id;


    /**
     * 教工名称
     */
    @NotBlank(message = "教工名称不能为空")
    private String jgmc;



    /**
     * 排课的备注说明
     */
    private String bz;





}
