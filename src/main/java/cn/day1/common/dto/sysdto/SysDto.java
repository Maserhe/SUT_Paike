package cn.day1.common.dto.sysdto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/3/22 2:54 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实验室号
     */
    @NotBlank(message = "实验室号不能为空")
    private String sysh;

    /**
     * 实验室名称
     */
    @NotBlank(message = "实验室名称不能为空")
    private String sysmc;

    /**
     * 实验室门牌号
     */
    @NotBlank(message = "实验室门牌号不能为空")
    private String sysmph;


}
