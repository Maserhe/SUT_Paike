package cn.day1.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * 统一返回 成功是0， 失败是-1
 * @author maserhe
 * @date 2022/3/6 1:23 下午
 **/
@Data
public class Result implements Serializable {

    private String code;

    private String msg;

    private Object data;

    public static Result succ(Object data) {

        Result m = new Result();
        m.setCode("0");
        m.setData(data);
        m.setMsg("操作成功");
        return m;
    }
    public static Result succ(String mess, Object data) {
        Result m = new Result();
        m.setCode("0");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }
    public static Result fail(String mess) {

        Result m = new Result();
        m.setCode("-1");
        m.setData(null);
        m.setMsg(mess);
        return m;
    }
    public static Result fail(String mess, Object data) {

        Result m = new Result();
        m.setCode("-1");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }

    /**
     * 完全自定义 结果
     * @param mess
     * @param code
     * @param data
     * @return
     */
    public static Result res(String mess, String code, String data) {
        Result m = new Result();
        m.setMsg(mess);
        m.setCode(code);
        m.setData(data);

        return m;
    }
}
