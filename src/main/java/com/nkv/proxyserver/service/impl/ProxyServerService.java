package com.nkv.proxyserver.service.impl;

import com.nkv.proxyserver.dto.NginxStatisticDTO;
import com.nkv.proxyserver.dto.RequestDTO;
import com.nkv.proxyserver.service.IProxyServerService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class ProxyServerService implements IProxyServerService {

    private static final Logger log = LoggerFactory.getLogger(ProxyServerService.class);

    @Override
    public NginxStatisticDTO getNginxStatistic() {
        NginxStatisticDTO nginxStatisticDTO = new NginxStatisticDTO();
        String nginxStatistic = "";
        try {
            nginxStatistic = sendGet("http://172.20.128.2/nginx_status");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return convertStatisticStringToDTO(nginxStatistic);
    }

    public NginxStatisticDTO convertStatisticStringToDTO(String responseFromNginx) {
        NginxStatisticDTO nginxStatisticDTO = new NginxStatisticDTO();
        RequestDTO requestDTO = new RequestDTO();

        String[] splitedResponse = responseFromNginx.split("\\n");

        String[] splittedRequests = splitedResponse[2].split(" ");
        requestDTO.setAccepts(Long.valueOf(splittedRequests[1]));
        requestDTO.setHandled(Long.valueOf(splittedRequests[2]));
        requestDTO.setRequests(Long.valueOf(splittedRequests[3]));

        String[] splitedConnections = splitedResponse[0].split(": ");
        nginxStatisticDTO.setActiveConnections(Long.valueOf(splitedConnections[1].trim()));
        nginxStatisticDTO.setRequest(requestDTO);

        return nginxStatisticDTO;
    }

    private String sendGet(String url) throws IOException {
        String result;
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            try (InputStream in = new BufferedInputStream(con.getInputStream())) {
                result = IOUtils.toString(in, StandardCharsets.UTF_8);
            }
        } else {
            try (InputStream in = new BufferedInputStream(con.getErrorStream())) {
                result = IOUtils.toString(in, StandardCharsets.UTF_8);
            }
        }
        return result;
    }
}
