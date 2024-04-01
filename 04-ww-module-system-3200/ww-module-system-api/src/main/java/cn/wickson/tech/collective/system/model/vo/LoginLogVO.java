package cn.wickson.tech.collective.system.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "LoginLogVO对象", description = "管理后台-登录日志信息")
public class LoginLogVO {

    @ApiModelProperty(name = "日志类型，参见 LoginLogTypeEnum 枚举类", required = true, example = "1")
    @NotNull(message = "日志类型不能为空")
    private Integer logType;

    @ApiModelProperty(name = "链路追踪编号", example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;

    @ApiModelProperty(name = "用户编号", required = true, example = "666")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @ApiModelProperty(name = "用户类型，参见 UserTypeEnum 枚举", required = true, example = "2")
    @NotNull(message = "用户类型不能为空")
    private Integer userType;

    @ApiModelProperty(name = "用户账号", required = true, example = "yudao")
    @NotBlank(message = "用户账号不能为空")
    @Size(max = 30, message = "用户账号长度不能超过30个字符")
    private String username;

    @ApiModelProperty(name = "登录结果，参见 LoginResultEnum 枚举类", required = true, example = "1")
    @NotNull(message = "登录结果不能为空")
    private Integer result;

    @ApiModelProperty(name = "用户 IP", required = true, example = "127.0.0.1")
    @NotEmpty(message = "用户 IP 不能为空")
    private String userIp;

    @ApiModelProperty(name = "浏览器 UserAgent", required = true, example = "Mozilla/5.0")
    private String userAgent;

}
