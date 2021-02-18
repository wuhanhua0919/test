package com.ksq.service.impl;

import com.ksq.core.entity.SysUser;
import com.ksq.core.entity.SysUserExample;
import com.ksq.core.service.ISysUserService;
import com.ksq.service.dao.mapper.SysUserMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByLoginName(String loginName) {
        if(StringUtils.isBlank(loginName))
            return null;
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        List<SysUser> userList = sysUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)) return null;
        return  userList.get(0);
    }

}
