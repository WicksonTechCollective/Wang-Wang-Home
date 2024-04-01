package cn.wickson.tech.collective.system.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ZhangZiHeng
 * @date 2024-04-01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "OAuth2AccessTokenDTO对象", description = "管理后台 - OAuth2")
public class OAuth2AccessTokenDTO implements Serializable {

    @ApiModelProperty(name = "访问令牌", example = "tudou")
    private String accessToken;

    @ApiModelProperty(name = "刷新令牌", example = "haha")
    private String refreshToken;

    @ApiModelProperty(name = "用户编号", example = "10")
    private Long userId;

    @ApiModelProperty(name = "用户类型，参见 UserTypeEnum 枚举", example = "1")
    private Integer userType;

    @ApiModelProperty(name = "过期时间")
    private LocalDateTime expiresTime;

}
