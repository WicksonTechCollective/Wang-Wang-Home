package cn.wickson.tech.collective.auth.controller;

import cn.wickson.tech.collective.auth.model.vo.AuthSmsCodeReqVO;
import cn.wickson.tech.collective.auth.service.IAuthService;
import cn.wickson.tech.collective.auth.model.dto.AuthUserLoginRespDTO;
import cn.wickson.tech.collective.auth.model.vo.AuthUserLoginReqVO;
import cn.wickson.tech.collective.common.result.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 认证中心
 *
 * @author ZhangZiHeng
 * @date 2024-02-29
 */
@Slf4j
@RestController
@RequestMapping("/auth")
@Api(tags = "认证中心")
public class AuthController {

    @Resource
    private IAuthService authService;

    // region =========================================== 后台管理-账号密码登录 ===========================================

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "认证中心")
    public ResultUtil<AuthUserLoginRespDTO> login(@Valid @RequestBody AuthUserLoginReqVO reqVO) {
        return ResultUtil.success(authService.login(reqVO));
    }

    // endregion ======================================== 后台管理-账号密码登录 ===========================================


    // region =========================================== 后台管理-短信登录 ===========================================

    @PostMapping("/send-sms-code")
    @ApiOperation(value = "发送手机验证码", notes = "认证中心")
    public ResultUtil<Boolean> loginBySmsCode(@Valid @RequestBody AuthSmsCodeReqVO reqVO) {
        authService.loginBySmsCode(reqVO);
        return ResultUtil.success(true);
    }

    // endregion ======================================== 后台管理-短信登录 ===========================================


    @PostMapping("/logout")
    @ApiOperation(value = "用户登出", notes = "认证中心")
    public ResultUtil<?> logout(HttpRequestHandlerServlet request) {
        return null;
    }

}
