package cn.wickson.tech.collective.auth.service;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.wickson.tech.collective.auth.enums.ResultCodeAuth;
import cn.wickson.tech.collective.common.constant.CacheConstants;
import cn.wickson.tech.collective.common.enums.UseStatusEnum;
import cn.wickson.tech.collective.common.exception.UserOperationException;
import cn.wickson.tech.collective.common.redis.service.RedisService;
import cn.wickson.tech.collective.system.api.SystemUserApi;
import cn.wickson.tech.collective.system.model.dto.AdminUserDTO;
import cn.wickson.tech.collective.system.enums.LoginLogTypeEnum;
import cn.wickson.tech.collective.system.enums.LoginResultEnum;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * 用户登录-防腐层
 *
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
public class AbstractAuthService {

    @Value("${captcha.enable}")
    private Boolean enable;

    @Resource
    private RedisService redisService;

    @Resource
    protected SystemUserApi systemUserApi;

    @Resource
    protected ILoginLogService loginLogService;

    /**
     * 验证验证码
     *
     * @param code             uuid
     * @param verificationCode 验证码
     */
    protected void validCaptcha(String username, String code, String verificationCode) {
        // 如果没有开启验证码则不进行校验
        if (!Boolean.TRUE.equals(enable)) {
            return;
        }

        String captchaCodeKey = getCaptchaCodeKey(code);
        String verifyCode = redisService.getCacheObject(captchaCodeKey);
        // 验证验证码是否存在
        if (StrUtil.isBlankIfStr(verifyCode)) {
            // 记录日志
            loginLogService.createLoginLog(null, username, LoginLogTypeEnum.LOGIN_USERNAME, LoginResultEnum.CAPTCHA_NOT_FOUND);
            throw UserOperationException.getInstance(ResultCodeAuth.CAPTCHA_CODE_ERROR);
        }

        // 验证验证码是否正确
        if (!verificationCode.equals(verifyCode)) {
            // 验证错误，删除验证码
            redisService.deleteObject(captchaCodeKey);
            // 记录日志
            loginLogService.createLoginLog(null, username, LoginLogTypeEnum.LOGIN_USERNAME, LoginResultEnum.CAPTCHA_CODE_ERROR);
            throw UserOperationException.getInstance(ResultCodeAuth.CAPTCHA_CODE_ERROR);
        }

    }

    /**
     * 验证用户信息
     *
     * @param userInfo 用户信息
     * @param password 登录密码
     */
    protected void validUserInfo(AdminUserDTO userInfo, String code, String password) {
        // 当前用户是否存在
        if (ObjUtil.isNull(userInfo)) {
            // 记录日志
            loginLogService.createLoginLog(null, userInfo.getUsername(), LoginLogTypeEnum.LOGIN_USERNAME, LoginResultEnum.USER_NOT_FOUND);
            throw UserOperationException.getInstance(ResultCodeAuth.USER_NOT_FOUND);
        }
        // 当前用户密码是否正确
        if (!password.equals(userInfo.getPassword())) {
            // 记录日志J看。                                      +
            loginLogService.createLoginLog(null, userInfo.getUsername(), LoginLogTypeEnum.LOGIN_USERNAME, LoginResultEnum.BAD_CREDENTIALS);
            throw UserOperationException.getInstance(ResultCodeAuth.USER_PASSWORD_ERROR);
        }
        // 是否被禁用
        if (UseStatusEnum.DISABLE.getStatus().equals(userInfo.getStatus())) {
            // 记录日志
            loginLogService.createLoginLog(null, userInfo.getUsername(), LoginLogTypeEnum.LOGIN_USERNAME, LoginResultEnum.USER_DISABLED);
            throw UserOperationException.getInstance(ResultCodeAuth.USER_STATUS_DISABLE);
        }
        // 删除token
        redisService.deleteObject(getCaptchaCodeKey(code));
    }

    /**
     * 获取验证码索引 Key
     *
     * @param key key
     * @return String
     */
    private String getCaptchaCodeKey(String key) {
        return String.format(CacheConstants.CAPTCHA_CODE_KEY, key);
    }


}
