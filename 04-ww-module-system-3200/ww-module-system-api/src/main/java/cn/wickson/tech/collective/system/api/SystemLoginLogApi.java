package cn.wickson.tech.collective.system.api;

import cn.wickson.tech.collective.common.result.ResultUtil;
import cn.wickson.tech.collective.system.api.fallback.LoginLogFeignFallbackFactory;
import cn.wickson.tech.collective.system.dto.LoginLogDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@FeignClient(value = "wang-wang-home-system", fallbackFactory = LoginLogFeignFallbackFactory.class)
public interface SystemLoginLogApi {

    /**
     * 创建用户登录日志
     *
     * @param loginLogDTO 用户登录信息
     * @return
     */
    @PostMapping("/system/login-log/createLoginLog")
    ResultUtil<Boolean> createLoginLog(@RequestBody LoginLogDTO loginLogDTO);

}
