package cn.wickson.tech.collective.auth.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证中心
 *
 * @author ZhangZiHeng
 * @date 2024-02-29
 */
@Slf4j
@RestController
@RequestMapping("/auth")
@Api(tags = "认证中心")
public class AuthController {

    @PostMapping("/create-token")
    public void createToken() {

    }


}
