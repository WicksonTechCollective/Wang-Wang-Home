package cn.wickson.tech.collective.system.model.vo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserSaveReqVO extends AddUserSaveReqVO {

    @ApiModelProperty(name = "用户id", example = "1024", required = true)
    @NotNull(message = "用户id不能为空")
    private Long id;

}
