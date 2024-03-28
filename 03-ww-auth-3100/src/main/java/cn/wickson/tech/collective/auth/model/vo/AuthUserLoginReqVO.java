package cn.wickson.tech.collective.auth.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AuthUserLoginReqVO对象", description = "管理后台-用户登录信息")
public class AuthUserLoginReqVO {

    @ApiModelProperty(name = "账号", required = true, example = "wickson")
    @NotEmpty(message = "登录账号不能为空")
    @Length(min = 4, max = 16, message = "账号长度为 4-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String username;

    @ApiModelProperty(name = "密码", required = true, example = "123456")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

    @ApiModelProperty(value = "code", example = "8ad797d7-511f-4922-8526-ed15c7dab118")
    @NotEmpty(message = "code不能为空")
    private String code;

    @ApiModelProperty(value = "验证码", example = "8ad8")
    @NotEmpty(message = "验证码不能为空")
    @Length(min = 4, max = 4, message = "验证码的长度只有 4 位")
    private String verificationCode;

}
