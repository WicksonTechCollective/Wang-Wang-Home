package cn.wickson.tech.collective.system.api.fallback;

import cn.wickson.tech.collective.system.api.SystemLoginLogApi;
import cn.wickson.tech.collective.system.dto.LoginLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@Slf4j
@Component
public class LoginLogFeignFallbackClient implements SystemLoginLogApi {

    @Override
    public void createLoginLog(LoginLogDTO loginLogDTO) {
//        throw TripartiteInterfaceException.getInstance();
    }

}
