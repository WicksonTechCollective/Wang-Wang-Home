package cn.wickson.tech.collective.system.api.fallback;

import cn.wickson.tech.collective.common.exception.ServiceException;
import cn.wickson.tech.collective.common.result.ResultUtil;
import cn.wickson.tech.collective.system.api.SystemLoginLogApi;
import cn.wickson.tech.collective.system.dto.LoginLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@Slf4j
@Component
public class LoginLogFeignFallbackFactory implements FallbackFactory<SystemLoginLogApi> {

    @Override
    public SystemLoginLogApi create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new SystemLoginLogApi() {

            @Override
            public ResultUtil<Boolean> createLoginLog(LoginLogDTO loginLogDTO) {
                throw ServiceException.fail("保存操作日志失败");
            }

        };
    }
}
