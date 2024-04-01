package cn.wickson.tech.collective.auth.service.impl;

import cn.wickson.tech.collective.auth.service.ILoginLogService;
import cn.wickson.tech.collective.common.enums.UserTypeEnum;
import cn.wickson.tech.collective.common.utils.ServletUtils;
import cn.wickson.tech.collective.system.api.SystemLoginLogApi;
import cn.wickson.tech.collective.system.api.SystemUserApi;
import cn.wickson.tech.collective.system.model.vo.LoginLogVO;
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
        LoginLogVO loginLogVO = new LoginLogVO();
        loginLogVO.setUserId(userId);
        loginLogVO.setLogType(loginType.getType());
//        loginLogVO.setTraceId(TracerUtils.getTraceId());
        loginLogVO.setUserType(UserTypeEnum.ADMIN.getValue());
        loginLogVO.setUsername(username);
        loginLogVO.setUserAgent(ServletUtils.getUserAgent());
        loginLogVO.setUserIp(ServletUtils.getClientIP());
        loginLogVO.setResult(loginResult.getCode());
        systemLoginLogApi.createLoginLog(loginLogVO);

        // 更新最后登录时间
        if (userId != null && Objects.equals(LoginResultEnum.SUCCESS.getCode(), loginResult.getCode())) {
            systemUserApi.updateUserLogin(userId, ServletUtils.getClientIP());
        }
    }

}
