package com.ksq.core.service;

import com.ksq.core.entity.SysUser;

public interface ISysUserService {

    SysUser findByLoginName(String loginName);



}
