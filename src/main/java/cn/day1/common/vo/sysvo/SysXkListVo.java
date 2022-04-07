package cn.day1.common.vo.sysvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 *  查询某个班级的 实验室课表 list
 * @author maserhe
 * @date 2022/4/7 12:46 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysXkListVo implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;


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
        SysXkListVo t = (SysXkListVo) o;
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
