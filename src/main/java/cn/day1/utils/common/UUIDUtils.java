package cn.day1.utils.common;

import cn.hutool.core.lang.UUID;

/**
 * Description:
 * 生成uuid
 *
 * @author maserhe
 * @date 2022/3/22 7:37 下午
 **/
public class UUIDUtils {

    /**
     * 生成32位uuid
     * @return
     */
    public static String createUUUID() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
