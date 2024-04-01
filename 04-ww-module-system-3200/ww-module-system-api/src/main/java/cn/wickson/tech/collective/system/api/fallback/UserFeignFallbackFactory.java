package cn.wickson.tech.collective.system.api.fallback;

import cn.wickson.tech.collective.common.exception.ServiceException;
import cn.wickson.tech.collective.common.result.ResultUtil;
import cn.wickson.tech.collective.system.api.SystemUserApi;
import cn.wickson.tech.collective.system.model.dto.AdminUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@Slf4j
@Component
public class UserFeignFallbackFactory implements FallbackFactory<SystemUserApi> {

    @Override
    public SystemUserApi create(Throwable throwable) {

        log.error("用户服务调用失败:{}", throwable.getMessage());

        return new SystemUserApi() {
            @Override
            public ResultUtil<AdminUserDTO> getUserInfo(String username) {
                throw ServiceException.fail("获取用户失败");
            }

            @Override
            public ResultUtil<Boolean> updateUserLogin(Long userId, String clientIP) {
                throw ServiceException.fail("更新用户失败");
            }
        };
    }
}
