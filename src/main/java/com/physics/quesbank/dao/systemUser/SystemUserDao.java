package com.physics.quesbank.dao.systemUser;

import com.physics.quesbank.dao.baseMapper.BaseMapper;
import com.physics.quesbank.entity.systemUser.SystemUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemUserDao extends BaseMapper<SystemUser> {
    SystemUser getSystemUserByName(SystemUser systemUser);
}
