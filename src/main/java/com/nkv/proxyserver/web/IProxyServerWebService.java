package com.nkv.proxyserver.web;

import com.nkv.proxyserver.dto.NginxStatisticDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/service")
public interface IProxyServerWebService {

    @GetMapping(value = "/nginx/statistics")
    NginxStatisticDTO getNginxStatistic();
}
