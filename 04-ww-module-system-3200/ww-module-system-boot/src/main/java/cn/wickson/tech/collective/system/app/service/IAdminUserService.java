package cn.wickson.tech.collective.system.app.service;

import cn.wickson.tech.collective.system.dto.AdminUserDTO;
import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;

public interface IAdminUserService {

    /**
     * 创建用户
     *
     * @param reqVO 用户信息
     * @return 用户编号
     */
    Long createUser(AddUserSaveReqVO reqVO);

    /**
     * 通过用户id更新用户信息
     *
     * @param userId   用户id
     * @param clientIP 客户端ip
     */
    void updateUserById(Long userId, String clientIP);

    /**
     * 通过用户名称获取用户信息
     *
     * @param username 用户名
     * @return
     */
    AdminUserDTO getUserInfo(String username);
}
