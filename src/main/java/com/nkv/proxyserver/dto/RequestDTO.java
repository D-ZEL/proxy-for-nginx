package com.nkv.proxyserver.dto;

public class RequestDTO {

    private Long accepts;
    private Long handled;
    private Long requests;

    public Long getAccepts() {
        return accepts;
    }

    public void setAccepts(Long accepts) {
        this.accepts = accepts;
    }

    public Long getHandled() {
        return handled;
    }

    public void setHandled(Long handled) {
        this.handled = handled;
    }

    public Long getRequests() {
        return requests;
    }

    public void setRequests(Long requests) {
        this.requests = requests;
    }
}
