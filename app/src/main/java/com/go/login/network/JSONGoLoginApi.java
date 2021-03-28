package com.go.login.network;

import com.go.login.network.entity.LoginUserDTO;
import com.go.login.network.entity.RegistrationData;
import com.go.login.network.entity.TokenData;
import com.go.login.network.entity.UserEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface JSONGoLoginApi {

//    @GET("/posts/{id}")
//    public Call<UserEntity> getUser(@Path("id") int id);
    @GET("/user")
    public Call<UserEntity> getUser(@Header("Authorization") String token);
//    {
//        "username": "string",
//            "password": "string",
//            "fromApp": true,
//            "googleClientId": "string"
//    }
    @POST("/user")
    public Call<TokenData> postUser(@Body RegistrationData registrationData);
    @POST("/user/login")
    public Call<TokenData> postUserLogin(@Body LoginUserDTO loginUserDTO);

}
