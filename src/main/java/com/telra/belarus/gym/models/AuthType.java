package com.telra.belarus.gym.models;

/**
 * Created by Boris on 12.06.2017.
 */
public class AuthType {
    private String email;
    private String password;

    public AuthType() {
    }

    public AuthType(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
