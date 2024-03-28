package cn.wickson.tech.collective.common.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 客户端工具类
 *
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
public class ServletUtils {

    public static String getUserAgent() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        return getUserAgent(request);
    }

    /**
     * @param request 请求
     */
    public static String getUserAgent(HttpServletRequest request) {
        return StrUtil.nullToEmpty(request.getHeader("User-Agent"));
    }

    public static String getClientIP() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        return ServletUtil.getClientIP(request);
    }

    /**
     * 获得请求
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            return null;
        }
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

}
