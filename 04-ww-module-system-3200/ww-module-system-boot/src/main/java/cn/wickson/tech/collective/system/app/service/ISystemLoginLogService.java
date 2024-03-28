package cn.wickson.tech.collective.system.app.service;

import cn.wickson.tech.collective.system.dto.LoginLogDTO;

/**
 * 系统管理-用户登录信息
 *
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
public interface ISystemLoginLogService {

    /**
     * 新增登录日志
     *
     * @param loginLogDTO 登录信息
     */
    void createLoginLog(LoginLogDTO loginLogDTO);

}
