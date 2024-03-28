package cn.wickson.tech.collective.auth.service.impl;

import cn.wickson.tech.collective.auth.service.ILoginLogService;
import cn.wickson.tech.collective.common.enums.UserTypeEnum;
import cn.wickson.tech.collective.common.utils.ServletUtils;
import cn.wickson.tech.collective.system.api.SystemLoginLogApi;
import cn.wickson.tech.collective.system.api.SystemUserApi;
import cn.wickson.tech.collective.system.dto.LoginLogDTO;
import cn.wickson.tech.collective.system.enums.LoginLogTypeEnum;
import cn.wickson.tech.collective.system.enums.LoginResultEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@Service
public class LoginLogServiceImpl implements ILoginLogService {

    @Resource
    private SystemLoginLogApi systemLoginLogApi;

    @Resource
    private SystemUserApi systemUserApi;

    @Override
    public void createLoginLog(Long userId, String username, LoginLogTypeEnum loginType, LoginResultEnum loginResult) {
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        loginLogDTO.setUserId(userId);
        loginLogDTO.setLogType(loginType.getType());
//        loginLogDTO.setTraceId(TracerUtils.getTraceId());
        loginLogDTO.setUserType(UserTypeEnum.ADMIN.getValue());
        loginLogDTO.setUsername(username);
        loginLogDTO.setUserAgent(ServletUtils.getUserAgent());
        loginLogDTO.setUserIp(ServletUtils.getClientIP());
        loginLogDTO.setResult(loginResult.getResult());
        systemLoginLogApi.createLoginLog(loginLogDTO);

        // 更新最后登录时间
        if (userId != null && Objects.equals(LoginResultEnum.SUCCESS.getResult(), loginResult.getResult())) {
            systemUserApi.updateUserLogin(userId, ServletUtils.getClientIP());
        }
    }

}
