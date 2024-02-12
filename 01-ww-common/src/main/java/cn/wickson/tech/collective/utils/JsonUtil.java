package cn.wickson.tech.collective.utils;

import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * bean转换JSON工具类
 *
 * @author Wickson
 */
public class JsonUtil {

    /**
     * 获取Json格式的操作内容
     *
     * @return
     */
    public static String toJsonStr(final Object oldRecord, final Object newRecord) {
        Map<Object,Object> operationContentMap = new HashMap<Object,Object>();
        operationContentMap.put("beforeUpdate", oldRecord);
        operationContentMap.put("afterUpdating", newRecord);

        return toJsonStr(operationContentMap);
    }

    /**
     * 获取Json格式的操作内容
     *
     * @return
     */
    public static String toJsonStr(final Object newRecord) {
        return JSONUtil.toJsonStr(newRecord);
    }

}
