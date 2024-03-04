package cn.wickson.tech.collective.auth.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 停车场基本信息管理模块 - 新增参数类
 *
 * @author ZhangZiHeng
 * @date 2024-01-10
 */
@Getter
@Setter
@ApiModel(value = "AddParkingLotBasicInfoVO对象", description = "新增公司基本信息参数")
public class AddParkingLotBasicInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "所属运营商，运营商Id", required = true)
    @NotNull(message = "所属运营商不能为空")
    private Long operatorsId;

    @ApiModelProperty(name = "停车场名称", required = true)
    @NotBlank(message = "停车场名称不能为空")
    @Length(max = 100, message = "停车场名称长度超出限制，建议不超过100字符")
    private String parkingName;

    @ApiModelProperty(value = "省份数字码", required = true)
    @NotNull(message = "省份数字码不能为空")
    private Integer provinceNumberCode;

    @ApiModelProperty(value = "城市数字码", required = true)
    @NotNull(message = "城市数字码不能为空")
    private Integer cityNumberCode;

    @ApiModelProperty(value = "区(县)数字码", required = true)
    @NotNull(message = "区(县)数字码不能为空")
    private Integer areaNumberCode;

    @ApiModelProperty(name = "车位总数", required = true)
    @NotNull(message = "车位总数不能为空")
    @Min(value = 0, message = "车位总数范围在[0,10000]")
    @Max(value = 10000, message = "车位总数范围在[0,10000]")
    private Integer totalSpaces;

    @ApiModelProperty(name = "停车场启用状态(0-停用，1-启用（默认值为1）)", required = true)
    @Min(value = 0, message = "停车场启用状态(0-停用，1-启用（默认值为1）)")
    @Max(value = 1, message = "停车场启用状态(0-停用，1-启用（默认值为1）)")
    private Integer enabledStatus;

    @ApiModelProperty(value = "详细地址", required = false)
    @Length(max = 100, message = "详细地址长度超出限制，建议不超过100字符")
    private String address;

    @ApiModelProperty(value = "停车场经度", required = false)
    private BigDecimal longitude;

    @ApiModelProperty(value = "停车场纬度", required = false)
    private BigDecimal latitude;

    @ApiModelProperty(name = "备注", required = false)
    @Length(max = 255, message = "停车场名称长度超出限制，建议不超过255字符")
    private String note;

}
