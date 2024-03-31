package cn.wickson.tech.collective.system.model.entity.logger;

import cn.wickson.tech.collective.common.enums.UserTypeEnum;
import cn.wickson.tech.collective.system.enums.LoginLogTypeEnum;
import cn.wickson.tech.collective.common.model.entity.BaseDO;
import cn.wickson.tech.collective.system.enums.LoginResultEnum;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@TableName("system_login_log")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginLog extends BaseDO {

    /**
     * 日志主键
     */
    private Long id;

    /**
     * 日志类型
     * <p>
     * 枚举 {@link LoginLogTypeEnum}
     */
    private Integer logType;

    /**
     * 链路追踪编号
     */
    private String traceId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 用户类型
     * <p>
     * 枚举 {@link UserTypeEnum}
     */
    private Integer userType;

    /**
     * 用户账号
     * <p>
     * 冗余，因为账号可以变更
     */
    private String username;

    /**
     * 登录结果
     * <p>
     * 枚举 {@link LoginResultEnum}
     */
    private Integer result;

    /**
     * 用户 IP
     */
    private String userIp;

    /**
     * 浏览器 UA
     */
    private String userAgent;

}