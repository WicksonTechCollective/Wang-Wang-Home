package cn.wickson.tech.collective.system.controller;

import cn.wickson.tech.collective.common.result.ResultUtil;
import cn.wickson.tech.collective.system.app.service.IAdminUserService;
import cn.wickson.tech.collective.system.dto.AdminUserDTO;
import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 系统管理-用户信息
 *
 * @author ZhangZiHeng
 * @date 2024-03-01
 */
@RestController
@RequestMapping("/user")
@Api(tags = "系统管理-用户信息")
public class SystemUsersController {

    @Resource
    private IAdminUserService userService;

    @PostMapping("/create")
    @ApiOperation(value = "新增用户", notes = "系统管理-用户信息")
    public ResultUtil<Long> createUser(@Valid @RequestBody AddUserSaveReqVO reqVO) {
        return ResultUtil.success(userService.createUser(reqVO));
    }

    @GetMapping("/getUserInfo/{username}")
    @ApiOperation(value = "获取用户信息", notes = "系统管理-用户信息")
    public AdminUserDTO getUserInfo(@PathVariable("username") String username) {
        return userService.getUserInfo(username);
    }

    @PutMapping("/updateUserLogin/{userId}/{clientIP}")
    @ApiOperation(value = "新增登录信息", notes = "系统管理-用户信息")
    public void createUser(@PathVariable("userId") Long userId, @PathVariable("clientIP") String clientIP) {
        userService.updateUserById(userId, clientIP);
    }

}
