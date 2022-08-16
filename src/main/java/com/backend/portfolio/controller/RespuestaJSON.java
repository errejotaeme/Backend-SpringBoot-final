
package com.backend.portfolio.controller;


public class RespuestaJSON {
    private String accessToken;    

    public RespuestaJSON(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccesToken() {
        return accessToken;
    }

    public void setAccesToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
}
