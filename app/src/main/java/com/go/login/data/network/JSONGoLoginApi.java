package com.go.login.data.network;

import com.go.login.data.entity.LoginUserDTO;
import com.go.login.data.entity.RegistrationData;
import com.go.login.data.entity.TokenData;
import com.go.login.data.entity.UserEntity;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

@SuppressWarnings("UnnecessaryInterfaceModifier")
public interface JSONGoLoginApi {

    @GET("/user")
    public Single<UserEntity> getUser(@Header("Authorization") String token);

    @POST("/user")
    public Single<TokenData> postUser(@Body RegistrationData registrationData);

    @POST("/user/login")
    public Single<TokenData> postUserLogin(@Body LoginUserDTO loginUserDTO);

}
