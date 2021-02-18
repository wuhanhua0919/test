package com.ksq.sale.common.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ksq.core.service.ISysUserService;
import org.springframework.stereotype.Service;

@Service
public class RpcCommonService {


    @Reference(version = "1.0.0", timeout = 10000, retries = -1)
    public ISysUserService rpcSysUserService;

}
