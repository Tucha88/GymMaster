package com.telra.belarus.gym.models;

/**
 * Created by Boris on 11.06.2017.
 */
public class Token {
    private String token;
    private String state;
    private String id;

    public Token() {
    }

    public Token(String token, String state,String id) {
        this.id = id;
        this.token = token;
        this.state = state;
    }

    public String getToken() {

        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
