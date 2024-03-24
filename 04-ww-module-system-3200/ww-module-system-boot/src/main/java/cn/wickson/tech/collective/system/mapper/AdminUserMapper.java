package cn.wickson.tech.collective.system.mapper;

import cn.wickson.tech.collective.system.model.entity.AdminUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    /**
     * 校验用户名唯一
     *
     * @param username 用户名
     * @return AdminUser
     */
    default AdminUser selectByUsername(String username) {
        return selectOne(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getUsername, username));
    }

    /**
     * 校验手机号唯一
     *
     * @param mobile 手机号
     * @return AdminUser
     */
    default AdminUser selectByMobile(String mobile) {
        return selectOne(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getMobile, mobile));
    }

    /**
     * 校验邮箱唯一
     *
     * @param email 邮箱
     * @return AdminUser
     */
    default AdminUser selectByEmail(String email) {
        return selectOne(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getEmail, email));
    }
}
