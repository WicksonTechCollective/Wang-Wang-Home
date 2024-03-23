package cn.wickson.tech.collective.system.app.service.impl;

import cn.wickson.tech.collective.system.app.service.AbstractSystemServiceAppService;
import cn.wickson.tech.collective.system.app.service.ISystemUserService;
import cn.wickson.tech.collective.system.model.vo.user.AddUserSaveReqVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemUserServiceImpl extends AbstractSystemServiceAppService implements ISystemUserService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createUser(AddUserSaveReqVO reqVO) {
        return null;
    }


}
