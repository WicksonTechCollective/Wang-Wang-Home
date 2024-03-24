package cn.wickson.tech.collective.system.app.service;

import cn.wickson.tech.collective.system.app.service.impl.AdminUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SystemUserServiceImplTest {

    @Resource
    private AdminUserServiceImpl userService;

    @Test
    public void createUser() {
        // 准备参数

    }


}