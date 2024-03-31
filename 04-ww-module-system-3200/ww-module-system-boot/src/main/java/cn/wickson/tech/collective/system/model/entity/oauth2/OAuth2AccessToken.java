package cn.wickson.tech.collective.system.model.entity.oauth2;

import cn.wickson.tech.collective.common.enums.UserTypeEnum;
import cn.wickson.tech.collective.common.model.entity.BaseDO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * OAuth2 获取token
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "system_oauth2_access_token", autoResultMap = true)
public class OAuth2AccessToken extends BaseDO {

    /**
     * 编号，数据库递增
     */
    @TableId
    private Long id;

    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 刷新令牌
     * {@link OAuth2RefreshToken#getRefreshToken()}
     */
    private String refreshToken;
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
     * 客户端编号
     * <p>
     */
    private String clientId;

    /**
     * 授权范围
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> scopes;

    /**
     * 过期时间
     */
    private LocalDateTime expiresTime;

}

