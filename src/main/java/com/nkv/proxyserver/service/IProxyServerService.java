package com.nkv.proxyserver.service;

import com.nkv.proxyserver.dto.NginxStatisticDTO;

public interface IProxyServerService {

    NginxStatisticDTO getNginxStatistic();

}
