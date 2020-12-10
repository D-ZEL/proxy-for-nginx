package com.nkv.proxyserver.service;

import com.nkv.proxyserver.dto.NginxStatisticDTO;
import com.nkv.proxyserver.service.impl.ProxyServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest
@AutoConfigureTestEntityManager
public class ProxyServerServiceTests extends AbstractTestNGSpringContextTests {

    @Autowired
    ProxyServerService proxyServerService;

    @Test
    public void convertStatisticStringToDTOTest() {
        String testString = "Active connections: 24 \n" +
                "server accepts handled requests\n" +
                " 15874 14741 216587496 \n" +
                "Reading: 0 Writing: 1 Waiting: 0 \n";
        NginxStatisticDTO nginxStatisticDTO = proxyServerService.convertStatisticStringToDTO(testString);
        Assert.assertNotNull(nginxStatisticDTO);
        Assert.assertEquals(nginxStatisticDTO.getActiveConnections().longValue(), 24L);
        Assert.assertEquals(nginxStatisticDTO.getRequest().getAccepts().longValue(), 15874L);
        Assert.assertEquals(nginxStatisticDTO.getRequest().getHandled().longValue(), 14741L);
        Assert.assertEquals(nginxStatisticDTO.getRequest().getRequests().longValue(), 216587496L);
    }
}
