package cn.day1.common.dto.sysdto;

import cn.day1.common.vo.jsxkvo.ClassVo;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Description:
 *
 *  添加实验室选课
 * @author maserhe
 * @date 2022/4/3 7:01 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSysXkDto {

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
     * 教工名称
     */
    @NotBlank(message = "教工名称不能为空")
    private String jgmc;

    /**
     * 实验室号
     */
    @NotBlank(message = "实验室号不能为空")
    private String sysh;

    /**
     * 实验室名称
     */

    @NotBlank(message = "实验室名称不能为空")
    private String sysmph;

    /**
     * 实验室所在的院系所名称
     */
    @NotBlank(message = "院系所号不能为空")
    private String yxsh;

    /**
     * 排课的备注说明
     */
    private String bz;



    /**
     * 教工id
     */
    @NotBlank(message = "教工id不能为空")
    private String jg0101id;

}
