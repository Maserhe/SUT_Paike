package cn.day1.common.dto.sysdto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/3/22 7:49 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSysDto implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 实验室名称, 可以为空，默认 机房
     */
    private String sysmc;

    /**
     * 实验室门牌号
     */
    @NotBlank(message = "实验室门牌号不能为空")
    private String sysmph;

    /**
     * 院系所号
     */
    @NotBlank(message = "院系所号不能为空")
    private String yxsh;

    /**
     * 院系所名称
     */
    @NotBlank(message = "院系所名称不能为空")
    private String yxmc;

    /**
     * 实验室的容量
     */
    @NotBlank(message = "人数不能为空")
    private String capacity;

    /**
     * 实验室的状态
     */
    @NotBlank(message = "实验室的状态不能为空")
    private String systype;

}
