package com.restaurant.system.model;

public class LoginResponse {

    private boolean authenticated;
    private Integer customerId;

    public LoginResponse(boolean authenticated, Integer customerId) {
        this.authenticated = authenticated;
        this.customerId = customerId;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
