package cn.wickson.tech.collective.auth.model.vo;

import cn.wickson.tech.collective.common.validator.Mobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author ZhangZiHeng
 * @date 2024-03-30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AuthSmsCodeReqVO对象", description = "管理后台-短信登录信息")
public class AuthSmsCodeReqVO {

    @ApiModelProperty(name = "手机号",required = true, example = "13807289561")
    @NotBlank(message = "手机号不能为空")
    @Mobile
    private String mobile;

}
