package com.go.login.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//{
//        "_id": "string",
//        "access_token": "string",
//        "refresh_token": "string",
//        "token": "string"
//        }


/**
 * String id, String accessToken, String refreshToken, String token
 */
public class TokenData {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("refresh_token")
    @Expose
    private String refreshToken;
    @SerializedName("token")
    @Expose
    private String token;
}
