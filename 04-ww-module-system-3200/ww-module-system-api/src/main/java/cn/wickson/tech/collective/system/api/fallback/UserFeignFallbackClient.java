package cn.wickson.tech.collective.system.api.fallback;

import cn.wickson.tech.collective.system.api.SystemUserApi;
import cn.wickson.tech.collective.system.dto.AdminUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@Slf4j
@Component
public class UserFeignFallbackClient implements SystemUserApi {

    @Override
    public AdminUserDTO getUserInfo(String username) {
        return null;
    }

    @Override
    public void updateUserLogin(Long userId, String clientIP) {

    }

}
