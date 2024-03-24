package cn.wickson.tech.collective.system.controller;

import cn.wickson.tech.collective.system.app.service.IAdminUserService;
import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author ZhangZiHeng
 * @date 2024-03-01
 */
@Api(tags = "系统管理")
@RestController
@RequestMapping("/user")
public class SystemUsersController {

    @Resource
    private IAdminUserService userService;

    @PostMapping("/create")
    @Operation(summary = "新增用户")
//    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public Long createUser(@Valid @RequestBody AddUserSaveReqVO reqVO) {
        return userService.createUser(reqVO);
    }

}
