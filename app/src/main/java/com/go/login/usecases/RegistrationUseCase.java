package com.go.login.usecases;

import com.go.login.data.network.JSONGoLoginApi;
import com.go.login.data.network.TokenProvider;
import com.go.login.data.entity.RegistrationData;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RegistrationUseCase {

    private final JSONGoLoginApi jsonGoLoginApi;
    private final TokenProvider tokenProvider;

    public RegistrationUseCase(JSONGoLoginApi jsonGoLoginApi, TokenProvider tokenProvider) {
        this.jsonGoLoginApi = jsonGoLoginApi;
        this.tokenProvider = tokenProvider;
    }
    public Completable registration(RegistrationData registrationData){
        return Completable.fromSingle(jsonGoLoginApi
                .postUser(registrationData)
                .doOnSuccess(tokenData -> {
                    tokenProvider.setPref(tokenData.getToken());
                })
                .subscribeOn(Schedulers.io())
        );
    }
}
