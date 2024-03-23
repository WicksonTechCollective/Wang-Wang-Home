package cn.wickson.tech.collective.system.app.service;

import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;

public interface ISystemUserService {

    /**
     * 创建用户
     *
     * @param reqVO 用户信息
     * @return 用户编号
     */
    Long createUser(AddUserSaveReqVO reqVO);

}
