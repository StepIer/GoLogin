package com.go.login.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/*
* LoginUserDTO{
username*	string
password*	string
fromApp*	boolean
googleClientId*	string
}
* */
public class LoginUserDTO {

    public LoginUserDTO(String username, String password, boolean fromApp, String googleClientId) {
        this.username = username;
        this.password = password;
        this.fromApp = fromApp;
        this.googleClientId = googleClientId;
    }

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;


    @SerializedName("fromApp")
    @Expose
    private boolean fromApp;
    @SerializedName("googleClientId")
    @Expose
    private String googleClientId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFromApp() {
        return fromApp;
    }

    public void setFromApp(boolean fromApp) {
        this.fromApp = fromApp;
    }

    public String getGoogleClientId() {
        return googleClientId;
    }

    public void setGoogleClientId(String googleClientId) {
        this.googleClientId = googleClientId;
    }

}
