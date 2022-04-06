package cn.day1.common.dto.sysdto;

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
 * @date 2022/4/4 10:50 上午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSysXkTableDto implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 学年学期
     */
    @NotBlank(message = "学年学期不能为空")
    private String xnxq01id;
    /**
     * 排课周次
     */
    @NotBlank(message = "排课周次不能为空")
    private String kkzc;


    /**
     * 实验室号
     */
    @NotBlank(message = "实验室号不能为空")
    private String sysh;



}
