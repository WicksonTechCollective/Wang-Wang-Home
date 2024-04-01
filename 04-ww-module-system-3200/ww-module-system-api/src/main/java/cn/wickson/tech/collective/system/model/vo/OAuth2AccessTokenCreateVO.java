package cn.wickson.tech.collective.system.model.vo;

import cn.wickson.tech.collective.common.enums.UserTypeEnum;
import cn.wickson.tech.collective.common.validator.InEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ZhangZiHeng
 * @date 2024-04-01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "OAuth2AccessTokenCreateVO对象", description = "管理后台- OAuth2 创建 Token")
public class OAuth2AccessTokenCreateVO {

    @ApiModelProperty(name = "用户编号", required = true, example = "10")
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    @ApiModelProperty(name = "用户类型，参见 UserTypeEnum 枚举", required = true, example = "1")
    @NotNull(message = "用户类型不能为空")
    @InEnum(value = UserTypeEnum.class, message = "用户类型必须是 {value}")
    private Integer userType;

    @ApiModelProperty(name = "客户端编号", required = true, example = "1000")
    @NotNull(message = "客户端编号不能为空")
    private String clientId;

    @ApiModelProperty(name = "授权范围的数组", example = "user_info")
    private List<String> scopes;

}
