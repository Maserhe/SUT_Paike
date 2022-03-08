package cn.day1.utils.common;


import com.alibaba.fastjson.JSONObject;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/3/8 9:15 上午
 **/
public class JsonConvertUtil {

    private JsonConvertUtil() {}

    /**
     * JSON 转 Object
     */
    public static <T> T jsonToObject(String pojo, Class<T> clazz) {
        return JSONObject.parseObject(pojo, clazz);
    }

    /**
     * Object 转 JSON
     */
    public static <T> String objectToJson(T t){
        return JSONObject.toJSONString(t);
    }
}