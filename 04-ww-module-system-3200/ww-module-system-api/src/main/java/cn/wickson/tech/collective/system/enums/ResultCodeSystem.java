package cn.wickson.tech.collective.system.enums;

import cn.wickson.tech.collective.common.enums.ResultCode;

/**
 * System 错误码枚举类
 * <p>
 * system 系统，使用 1-002-000-000 段
 */
public interface ResultCodeSystem {

    // ======================================== AUTH 模块 1-002-000-000 ========================================

    // ======================================== 用户模块 1-002-001-000 ========================================
    ResultCode USER_USERNAME_EXISTS = new ResultCode(1002001000, "用户账号已经存在");
    ResultCode USER_MOBILE_EXISTS = new ResultCode(1002001001, "手机号已经存在");
    ResultCode USER_EMAIL_EXISTS = new ResultCode(1002001002, "邮箱已经存在");


}
