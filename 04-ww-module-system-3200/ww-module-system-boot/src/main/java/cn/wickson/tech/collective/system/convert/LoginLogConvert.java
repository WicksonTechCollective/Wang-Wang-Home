package cn.wickson.tech.collective.system.convert;

import cn.wickson.tech.collective.system.dto.LoginLogDTO;
import cn.wickson.tech.collective.system.model.entity.LoginLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 登录日志-转换类
 *
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    LoginLog dtoToEntity(LoginLogDTO loginLogDTO);

}
