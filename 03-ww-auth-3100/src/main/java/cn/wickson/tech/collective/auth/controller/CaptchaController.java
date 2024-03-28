package cn.wickson.tech.collective.auth.controller;

import cn.wickson.tech.collective.auth.service.ICaptchaService;
import cn.wickson.tech.collective.auth.model.dto.CaptchaImageRespDTO;
import cn.wickson.tech.collective.common.result.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 验证码-控制类
 *
 * @author ZhangZiHeng
 * @date 2024-03-27
 */
@Api(tags = "验证码")
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Resource
    private ICaptchaService captchaService;

    @GetMapping("/getCaptchaImage")
    @ApiOperation("获取验证码")
    public ResultUtil<CaptchaImageRespDTO> getCaptchaImage() {
        return ResultUtil.success(captchaService.getCaptchaImage());
    }


}
