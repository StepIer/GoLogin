package com.go.login.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface JSONGoLoginApi {

//    @GET("/posts/{id}")
//    public Call<UserEntity> getUser(@Path("id") int id);
    @GET("/user")
    public Call<UserEntity> getUser();
//    {
//        "username": "string",
//            "password": "string",
//            "fromApp": true,
//            "googleClientId": "string"
//    }
    @POST("/user")
    public Call<TokenData> postUser(@Body RegistrationData registrationData);
    @POST("/user/login")
    public Call<UserEntity> postUserLogin();

}
