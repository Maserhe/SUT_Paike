package cn.day1.common.vo.countcourse;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/5/24 15:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YxsCountvo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 单位号,单位编码
     */
    private String dwh;

    /**
     * 单位名称
     */
    private String dwmc;

    /**
     * 单位英文名称,单位英文名称
     */
    private String dwywmc;

    /**
     * 单位简称,单位简称
     */
    private String dwjc;


    private String sum;
}
