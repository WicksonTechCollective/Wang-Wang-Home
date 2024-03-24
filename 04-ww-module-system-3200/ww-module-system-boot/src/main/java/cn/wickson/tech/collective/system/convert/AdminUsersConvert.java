package cn.wickson.tech.collective.system.convert;


import cn.wickson.tech.collective.system.model.entity.AdminUser;
import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminUsersConvert {

    AdminUsersConvert INSTANCE = Mappers.getMapper(AdminUsersConvert.class);

    AdminUser addVOToEntity(AddUserSaveReqVO reqVO);

}
