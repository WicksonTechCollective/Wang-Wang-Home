package cn.wickson.tech.collective.auth.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AuthUserLoginRespVO对象", description = "管理后台-登录返回信息")
public class AuthUserLoginRespDTO {

    @ApiModelProperty(name = "用户编号", example = "1024")
    private Long userId;

    @ApiModelProperty(name = "访问令牌",  example = "happy")
    private String accessToken;

    @ApiModelProperty(name = "刷新令牌", example = "nice")
    private String refreshToken;

    @ApiModelProperty(name = "过期时间")
    private LocalDateTime expiresTime;

}
