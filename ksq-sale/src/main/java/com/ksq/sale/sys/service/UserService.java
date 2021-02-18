package com.ksq.sale.sys.service;

import com.ksq.core.entity.SysUser;
import com.ksq.sale.common.service.RpcCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private RpcCommonService rpcCommonService;


    public SysUser findByLoginName(String loginName) {
        return rpcCommonService.rpcSysUserService.findByLoginName(loginName);
    }



}
