package com.restaurant.system.model;

public class LoginResponse {

    private boolean authenticated;
    private Integer customerId;
    private String userName;
    private String Address;
    private long Phoneno;

    public LoginResponse(boolean authenticated, Integer customerId) {
        this.authenticated = authenticated;
        this.customerId = customerId;
    }

    public LoginResponse( boolean authenticated, Integer customerId, String userName, String address, long phoneno) {
        this.authenticated = authenticated;
        this.customerId = customerId;
        this.userName = userName;
        Address = address;
        Phoneno = phoneno;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public long getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(long phoneno) {
        Phoneno = phoneno;
    }
}
