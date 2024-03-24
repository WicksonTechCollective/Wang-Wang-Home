package cn.wickson.tech.collective.system.app.service.impl;

import cn.wickson.tech.collective.common.enums.CommonStatusEnum;
import cn.wickson.tech.collective.common.utils.ParamFormatUtil;
import cn.wickson.tech.collective.system.app.service.AbstractAdminServiceService;
import cn.wickson.tech.collective.system.app.service.IAdminUserService;
import cn.wickson.tech.collective.system.convert.AdminUsersConvert;
import cn.wickson.tech.collective.system.model.entity.AdminUser;
import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminUserServiceImpl extends AbstractAdminServiceService implements IAdminUserService {

//    @Resource
//    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createUser(AddUserSaveReqVO reqVO) {
        /* Step-1：参数格式化处理 */
        ParamFormatUtil.formatParam(reqVO);

        /* Step-2: 参数验证 */
        this.validAddParam(reqVO);

        /* Step-3: 新增数据 */
        AdminUser adminUser =  AdminUsersConvert.INSTANCE.addVOToEntity(reqVO);
        adminUser.setStatus(CommonStatusEnum.ENABLE.getStatus());
        adminUser.setPassword("123456");
        userMapper.insert(adminUser);
        return adminUser.getId();
    }

    /**
     * 对密码进行加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
//    private String encodePassword(String password) {
//        return passwordEncoder.encode(password);
//    }

}
