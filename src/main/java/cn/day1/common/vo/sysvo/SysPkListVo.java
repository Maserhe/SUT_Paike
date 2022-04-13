package cn.day1.common.vo.sysvo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *  教师 获取排课列表
 * @author maserhe
 * @date 2022/4/13 6:05 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPkListVo implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级名称
     */
    private List<String> bjmcList;


    /**
     * 排课周次
     */
    private String kkzc;


    /**
     * 开课的 天
     */
    private String kkDay;

    /**
     * 开课的 节
     */
    private String kkSection;

    /**
     * 课程名称
     */
    private String kcmc;


    /**
     * 教工名称
     */
    private String jgmc;


    /**
     * 实验室号
     */
    private String sysh;

    /**
     * 实验室门牌号
     */
    private String sysmph;

    /**
     * 实验室所在的院系所名称
     */
    private String yxsmc;

    /**
     * 排课的备注说明
     */
    private String bz;

    @Override
    public int compareTo(Object o) {
        SysPkListVo t = (SysPkListVo) o;
        int i = Integer.valueOf(this.kkzc).compareTo(Integer.valueOf(t.getKkzc()));

        if (i == 0) {
            i = Integer.valueOf(this.kkDay).compareTo(Integer.valueOf(t.getKkDay()));
        }
        if (i == 0) {
            i = Integer.valueOf(this.kkSection).compareTo(Integer.valueOf(t.getKkSection()));
        }
        if (i == 0) {
            i = this.kcmc.compareTo(t.getKcmc());
        }
        return i;
    }


}
