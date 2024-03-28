package cn.wickson.tech.collective.auth.service;

import cn.wickson.tech.collective.system.enums.LoginLogTypeEnum;
import cn.wickson.tech.collective.system.enums.LoginResultEnum;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
public interface ILoginLogService {

    /**
     * 记录登录日志
     *
     * @param id          用户id
     * @param username    用户名称
     * @param loginType 登录方式
     * @param result      登录结果
     */
    void createLoginLog(Long id, String username, LoginLogTypeEnum loginType, LoginResultEnum result);

}
