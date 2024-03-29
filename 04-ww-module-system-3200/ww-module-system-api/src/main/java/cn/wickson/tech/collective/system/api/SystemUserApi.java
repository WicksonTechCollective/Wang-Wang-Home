package cn.wickson.tech.collective.system.api;

import cn.wickson.tech.collective.system.api.fallback.UserFeignFallbackClient;
import cn.wickson.tech.collective.system.dto.AdminUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@FeignClient(value = "wang-wang-home-system", fallback = UserFeignFallbackClient.class)
public interface SystemUserApi {

    /**
     * 通过用户名获取用户信息
     *
     * @param username 登录名称
     * @return
     */
    @GetMapping("/system/user/getUserInfo/{username}")
    AdminUserDTO getUserInfo(@PathVariable("username") String username);

    /**
     * 更新用户登录时间和登录ip
     *
     * @param userId   用户id
     * @param clientIP 客户端ip
     */
    @PutMapping("/system/user/updateUserLogin/{userId}/{clientIP}")
    void updateUserLogin(@PathVariable("userId") Long userId, @PathVariable("clientIP") String clientIP);
}
