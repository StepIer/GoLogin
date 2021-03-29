package com.go.login.network;

import retrofit2.Retrofit;

public class NetworkService {
    public static final String BASE_URL = "https://api.gologin.app";
    public final Retrofit mRetrofit;

    public NetworkService(Retrofit retrofit) {
       mRetrofit = retrofit;
    }
}

