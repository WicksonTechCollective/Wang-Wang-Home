package cn.wickson.tech.collective.auth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @ApiOperation(value = "新增接口", notes = "新增停车场基本信息")
    @PostMapping("/add")
    public void add(HttpServletRequest request, @Validated @RequestBody AddParkingLotBasicInfoVO addVO) {
    }


}
