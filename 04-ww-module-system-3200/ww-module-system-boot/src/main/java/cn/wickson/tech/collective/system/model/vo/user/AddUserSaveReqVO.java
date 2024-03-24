package cn.wickson.tech.collective.system.model.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@ApiModel(value = "AddUserSaveReqVO对象", description = "新增管理后台-用户创建信息")
public class AddUserSaveReqVO {

    @ApiModelProperty(name = "用户账号", example = "Wickson")
    @NotBlank(message = "用户账号不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "用户账号由 数字、字母 组成")
    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    private String username;

    @ApiModelProperty(name = "用户昵称", example = "Jack")
    @Size(max = 30, message = "用户昵称长度不能超过30个字符")
    private String nickname;

    @ApiModelProperty(name = "备注", example = "我是一个用户")
    private String remark;

    @ApiModelProperty(name = "部门ID", example = "我是一个用户")
    private Long deptId;

    @ApiModelProperty(name = "岗位编号数组", example = "1")
    private Set<Long> postIds;

    @ApiModelProperty(name = "用户邮箱", example = "wickson@163.com")
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过 50 个字符")
    private String email;

    @ApiModelProperty(name = "手机号码", example = "15601691300")
    private String mobile;

    @ApiModelProperty(name = "用户性别，参见 SexEnum 枚举类", example = "1")
    private Integer sex;

    @ApiModelProperty(name = "用户头像", example = "https://www.wickson.top/xxx.png")
    private String avatar;

    // ========== 仅【创建】时，需要传递的字段 ==========

    @ApiModelProperty(name = "密码", example = "123456")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

}
