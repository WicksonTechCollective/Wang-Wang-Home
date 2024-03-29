package cn.wickson.tech.collective.common.web.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * OpenFeign 日志配置
 */
public class FeignConfig {

    /**
     * 1. `NONE`：默认的，不显示任何日志
     * 2. `BASIC`：仅记录请求方法、URL、响应状态以及执行时间
     * 3. `HEADERS`：除了 `Basic` 中定义的信息之外，还有请求和响应头信息
     * 4. `FULL`：除了 `Headers` 中定义的信息之外，还有请求和响应的正文以及元数据
     *
     * @return Logger.Level
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}