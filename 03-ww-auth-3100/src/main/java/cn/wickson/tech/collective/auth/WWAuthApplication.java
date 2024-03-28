package cn.wickson.tech.collective.auth;

import cn.wickson.tech.collective.system.api.SystemLoginLogApi;
import cn.wickson.tech.collective.system.api.SystemUserApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 登录认证类-Auth
 *
 * @author Wickson
 */
@EnableFeignClients(basePackageClasses = {SystemLoginLogApi.class, SystemUserApi.class})
@SpringBootApplication
@EnableDiscoveryClient
public class WWAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WWAuthApplication.class, args);
    }

}