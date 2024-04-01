package cn.wickson.tech.collective.system.app.service.impl;

import cn.wickson.tech.collective.system.app.service.ISystemLoginLogService;
import cn.wickson.tech.collective.system.convert.LoginLogConvert;
import cn.wickson.tech.collective.system.model.vo.LoginLogVO;
import cn.wickson.tech.collective.system.mapper.LoginLogMapper;
import cn.wickson.tech.collective.system.model.entity.logger.LoginLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhangZiHeng
 * @date 2024-03-28
 */
@Service
public class SystemLoginLogServiceImpl implements ISystemLoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public Long createLoginLog(LoginLogVO loginLogVO) {
        /* Step-1: 将 DTO 转为实体信息 */
        LoginLog loginLog =  LoginLogConvert.INSTANCE.dtoToEntity(loginLogVO);

        /* Step-2: 新增数据 */
        loginLogMapper.insert(loginLog);

        /* Step-3: 返回数据 */
        return loginLog.getId();
    }


}
