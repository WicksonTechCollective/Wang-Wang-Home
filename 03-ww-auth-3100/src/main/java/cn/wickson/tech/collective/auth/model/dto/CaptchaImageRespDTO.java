package cn.wickson.tech.collective.auth.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 验证码返回VO
 *
 * @author ZhangZiHeng
 * @date 2024-03-27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AddUserSaveReqVO对象", description = "新增管理后台-用户创建信息")
public class CaptchaImageRespDTO {

    @ApiModelProperty(value = "是否开启验证码", required = true, example = "true")
    private Boolean enable;

    @ApiModelProperty(value = "code", example = "8ad797d7-511f-4922-8526-ed15c7dab118")
    private String code;

    @ApiModelProperty(value = "Base64 图片信息")
    private String images;

}
