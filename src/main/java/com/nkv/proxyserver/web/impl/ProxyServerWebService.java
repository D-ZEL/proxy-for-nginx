package com.nkv.proxyserver.web.impl;

import com.nkv.proxyserver.dto.NginxStatisticDTO;
import com.nkv.proxyserver.service.IProxyServerService;
import com.nkv.proxyserver.web.IProxyServerWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProxyServerWebService implements IProxyServerWebService {

    @Autowired
    IProxyServerService proxyServerService;

    @Override
    public NginxStatisticDTO getNginxStatistic() {
        return proxyServerService.getNginxStatistic();
    }
}
