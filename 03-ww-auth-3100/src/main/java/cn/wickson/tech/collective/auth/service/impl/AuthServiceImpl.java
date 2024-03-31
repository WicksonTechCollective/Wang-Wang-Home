package cn.wickson.tech.collective.auth.service.impl;

import cn.wickson.tech.collective.auth.model.dto.AuthUserLoginRespDTO;
import cn.wickson.tech.collective.auth.model.vo.AuthSmsCodeReqVO;
import cn.wickson.tech.collective.auth.model.vo.AuthUserLoginReqVO;
import cn.wickson.tech.collective.auth.service.AbstractAuthService;
import cn.wickson.tech.collective.auth.service.IAuthService;
import cn.wickson.tech.collective.system.dto.AdminUserDTO;
import cn.wickson.tech.collective.system.enums.LoginLogTypeEnum;
import cn.wickson.tech.collective.system.enums.LoginResultEnum;
import org.springframework.stereotype.Service;

/**
 * 后台用户-实现类
 *
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@Service
public class AuthServiceImpl extends AbstractAuthService implements IAuthService {

    @Override
    public AuthUserLoginRespDTO login(AuthUserLoginReqVO reqVO) {
        /* Step-1: 参数验证 */
        // 验证验证码
        this.validCaptcha(reqVO.getUsername(), reqVO.getCode(), reqVO.getVerificationCode());

        // 验证用户信息
        AdminUserDTO userInfo = systemUserApi.getUserInfo(reqVO.getUsername()).getCheckedData();
        this.validUserInfo(userInfo, reqVO.getCode(), reqVO.getPassword());

        /* Step-2: 记录登录日志，创建 Token 令牌 */
        // 记录日志
        loginLogService.createLoginLog(userInfo.getId(), userInfo.getUsername(), LoginLogTypeEnum.LOGIN_USERNAME, LoginResultEnum.SUCCESS);
        // 创建 Token 令牌
        return createAccessToken();
    }

    private AuthUserLoginRespDTO createAccessToken() {
        return AuthUserLoginRespDTO.builder().userId(1L).accessToken("123456").refreshToken("7891011").build();
    }


    @Override
    public void loginBySmsCode(AuthSmsCodeReqVO reqVO) {

    }
}
