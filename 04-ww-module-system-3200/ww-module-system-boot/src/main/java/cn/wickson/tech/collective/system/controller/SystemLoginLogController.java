package cn.wickson.tech.collective.system.controller;


import cn.wickson.tech.collective.common.result.ResultUtil;
import cn.wickson.tech.collective.system.app.service.ISystemLoginLogService;
import cn.wickson.tech.collective.system.model.vo.LoginLogVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统管理-登录日志
 *
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@RestController
@RequestMapping("/login-log")
@Api(tags = "系统管理-登录日志")
public class SystemLoginLogController {

    @Resource
    private ISystemLoginLogService systemLoginLogService;

    @PostMapping("/createLoginLog")
    @ApiOperation(value = "新增登录日志", notes = "系统管理-登录日志")
    public ResultUtil<Long> createLoginLog(@RequestBody LoginLogVO loginLogVO) {
        return ResultUtil.success(systemLoginLogService.createLoginLog(loginLogVO));
    }

}
