package cn.wickson.tech.collective.auth.service;

import cn.wickson.tech.collective.auth.model.dto.AuthUserLoginRespDTO;
import cn.wickson.tech.collective.auth.model.vo.AuthUserLoginReqVO;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
public interface IAuthService {

    /**
     * 用户账户密码登录
     *
     * @param reqVO 登录用户参数
     * @return
     */
    AuthUserLoginRespDTO login(AuthUserLoginReqVO reqVO);

}

