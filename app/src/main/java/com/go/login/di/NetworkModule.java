package com.go.login.di;


import android.content.Context;

import com.go.login.data.network.JSONGoLoginApi;
import com.go.login.data.network.NetworkService;
import com.go.login.data.network.TokenProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {


    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public NetworkService provideNetworkService(Retrofit retrofit) {
        return new NetworkService(retrofit);
    }
    @Provides
    public JSONGoLoginApi provideJSONGoLoginApi(Retrofit retrofit){
        return retrofit.create(JSONGoLoginApi.class);
    }
    @Provides
    public TokenProvider providerTokenProvider(Context context){
        return new TokenProvider(context);
    }

}
