package cn.wickson.tech.collective.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author ZhangZiHeng
 * @date 2024-03-01
 */
@Api(tags = "系统管理")
@RestController
@RequestMapping("/users")
public class SystemUsersController {

    @ApiOperation(value = "删除接口", notes = "删除一条停车场基本信息")
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    @DeleteMapping("/delete/{id}")
    public void delete(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        System.out.println("id = " + id);
    }

}
