package cn.wickson.tech.collective.system.convert;


import cn.wickson.tech.collective.system.model.dto.AdminUserDTO;
import cn.wickson.tech.collective.system.model.entity.user.AdminUser;
import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminUserConvert {

    AdminUserConvert INSTANCE = Mappers.getMapper(AdminUserConvert.class);

    AdminUser addVOToEntity(AddUserSaveReqVO reqVO);

    AdminUserDTO entityToDTO(AdminUser adminUser);
}
