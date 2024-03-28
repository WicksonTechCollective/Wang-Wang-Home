package cn.wickson.tech.collective.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author ZhangZiHeng
 * @date 2024-02-29
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class WWSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WWSystemApplication.class, args);
    }

}

