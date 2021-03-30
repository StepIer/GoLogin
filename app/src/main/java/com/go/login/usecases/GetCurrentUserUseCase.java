package com.go.login.usecases;

import com.go.login.data.network.JSONGoLoginApi;
import com.go.login.data.network.TokenProvider;
import com.go.login.data.entity.UserEntity;


import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class GetCurrentUserUseCase {
    private final JSONGoLoginApi jsonGoLoginApi;
    private final TokenProvider tokenProvider;
    public GetCurrentUserUseCase(JSONGoLoginApi jsonGoLoginApi, TokenProvider tokenProvider) {
        this.jsonGoLoginApi = jsonGoLoginApi;
        this.tokenProvider = tokenProvider;
    }

    public Single<UserEntity> getUser(){
        return jsonGoLoginApi
                .getUser("Bearer " + tokenProvider.getPref())
                .subscribeOn(Schedulers.io());

    }
}
