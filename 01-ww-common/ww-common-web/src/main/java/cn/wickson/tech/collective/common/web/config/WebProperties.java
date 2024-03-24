package cn.wickson.tech.collective.common.web.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

/**
 * 读取 web.prefix 前缀的配置项；
 * 因为现在提供了默认值，所以这个配置项就不用添加到 application.yaml 配置项了！
 */
@Data
@ConfigurationProperties(prefix = "web.prefix")
public class WebProperties {

    @NotNull(message = "APP API 不能为空")
    private Api appApi = new Api("/app-api", "**.controller.**");

    @NotNull(message = "Admin API 不能为空")
    private Api adminApi = new Api("/admin-api", "**.controller.**");

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Api {

        /**
         * API 前缀，实现所有 Controller 提供的 RESTFul API 的统一前缀
         * <p>
         * 意义：通过该前缀，避免 Swagger、Actuator 意外通过 Nginx 暴露出来给外部，带来安全性问题
         * 这样，Nginx 只需要配置转发到 /api/* 的所有接口即可。
         */
        private String prefix;

        /**
         * Controller 所在包的 Ant 路径规则
         * 主要目的是，给该 Controller 设置指定的 {@link #prefix}
         */
        private String controller;

    }

}
