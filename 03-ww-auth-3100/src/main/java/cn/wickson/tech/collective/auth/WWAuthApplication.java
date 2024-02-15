package cn.wickson.tech.collective.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 登录认证类-Auth
 *
 * @author Wickson
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WWAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WWAuthApplication.class, args);
    }

}