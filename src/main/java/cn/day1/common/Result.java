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

    /**
     *   200是正常，非200表示异常
     */
    private int code;

    private String msg;

    private Object data;


    public static Result succ(Object data) {
        return succ(200, "操作成功", data);
    }

    public static Result succ(String msg, Object data) {
        return succ(200, msg, data);
    }

    public static Result succ(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg) {
        return fail(400, msg, null);
    }

    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}
