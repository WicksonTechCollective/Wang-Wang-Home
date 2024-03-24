package cn.wickson.tech.collective.system.app.service;

import cn.hutool.core.util.ObjUtil;
import cn.wickson.tech.collective.common.exception.UserOperationException;
import cn.wickson.tech.collective.system.constant.ResultCodeConstants;
import cn.wickson.tech.collective.system.mapper.AdminUserMapper;
import cn.wickson.tech.collective.system.model.entity.AdminUser;
import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;

import javax.annotation.Resource;

public abstract class AbstractAdminServiceService {

    @Resource
    protected AdminUserMapper userMapper;

    protected void validAddParam(AddUserSaveReqVO reqVO) {
        // 校验用户名唯一
        validateUsernameUnique(reqVO.getUsername());
        // 校验手机号唯一
        validateMobileUnique(reqVO.getMobile());
        // 校验邮箱唯一
        validateEmailUnique(reqVO.getEmail());
        // TODO 校验部门处于开启状态

        // TODO 校验岗位处于开启状态
    }

    /**
     * 校验用户名唯一
     *
     * @param username 用户名
     */
    private void validateUsernameUnique(String username) {
        AdminUser adminUser = userMapper.selectByUsername(username);
        if (ObjUtil.isNotNull(adminUser)) {
            throw UserOperationException.getInstance(ResultCodeConstants.USER_USERNAME_EXISTS);
        }
    }

    /**
     * 校验手机号唯一
     *
     * @param mobile 手机号
     */
    private void validateMobileUnique(String mobile) {
        AdminUser adminUser = userMapper.selectByMobile(mobile);
        if (ObjUtil.isNotNull(adminUser)) {
            throw UserOperationException.getInstance(ResultCodeConstants.USER_MOBILE_EXISTS);
        }
    }

    /**
     * 校验邮箱唯一
     *
     * @param email 邮箱
     */
    private void validateEmailUnique(String email) {
        AdminUser adminUser = userMapper.selectByEmail(email);
        if (ObjUtil.isNotNull(adminUser)) {
            throw UserOperationException.getInstance(ResultCodeConstants.USER_EMAIL_EXISTS);
        }
    }

}
