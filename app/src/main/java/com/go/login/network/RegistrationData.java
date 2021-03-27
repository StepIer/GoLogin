package com.go.login.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//
//{
//        "email": "string",
//        "password": "string",
//        "passwordConfirm": "string",
//        "googleClientId": "string"
//        }



public class RegistrationData {

    public RegistrationData(String email, String password, String passwordConfirm, String googleClientId) {
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.googleClientId = googleClientId;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getGoogleClientId() {
        return googleClientId;
    }

    public void setGoogleClientId(String googleClientId) {
        this.googleClientId = googleClientId;
    }

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("passwordConfirm")
    @Expose
    private String passwordConfirm;
    @SerializedName("googleClientId")
    @Expose
    private String googleClientId;



}
