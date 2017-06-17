package com.telra.belarus.gym.models;

/**
 * Created by Boris on 12.06.2017.
 */
public class AuthType {
    private String emial;
    private String password;

    public AuthType() {
    }

    public AuthType(String emial, String password) {
        this.emial = emial;
        this.password = password;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
