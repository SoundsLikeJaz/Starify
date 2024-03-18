package br.edu.infnet.JacksonDaSilva.clients;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
    @JsonProperty("access_token")
    private String accessToken;

    public LoginResponse() {
    }

    public LoginResponse(String accessToken) {
        setAccessToken(accessToken);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}