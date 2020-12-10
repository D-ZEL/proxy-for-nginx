package com.nkv.proxyserver.dto;

public class NginxStatisticDTO {

    private Long activeConnections;
    private RequestDTO request;

    public Long getActiveConnections() {
        return activeConnections;
    }

    public void setActiveConnections(Long activeConnections) {
        this.activeConnections = activeConnections;
    }

    public RequestDTO getRequest() {
        return request;
    }

    public void setRequest(RequestDTO request) {
        this.request = request;
    }
}
