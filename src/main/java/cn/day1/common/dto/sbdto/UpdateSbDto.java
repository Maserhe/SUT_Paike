package cn.day1.common.dto.sbdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/5/22 15:48
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSbDto implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 实验室号
     */
    @NotBlank(message = "实验室号不能为空")
    private String sbh;

    /**
     * 设备名称
     */
    @NotBlank(message = "设备名称不能为空")
    private String sbmc;

    /**
     * 设备状态，0正常，1 故障
     */
    @NotBlank(message = "设备状态不能为空")
    private String sbzt;

    /**
     *  设备故障信息
     */
    private String info;

}