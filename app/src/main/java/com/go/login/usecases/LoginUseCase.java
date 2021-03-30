package com.go.login.usecases;

import com.go.login.data.network.JSONGoLoginApi;
import com.go.login.data.network.TokenProvider;
import com.go.login.data.entity.LoginUserDTO;

import io.reactivex.rxjava3.core.Completable;

import io.reactivex.rxjava3.schedulers.Schedulers;


public class LoginUseCase {
    private final JSONGoLoginApi jsonGoLoginApi;
    private final TokenProvider tokenProvider;

    public LoginUseCase(JSONGoLoginApi jsonGoLoginApi, TokenProvider tokenProvider) {
        this.jsonGoLoginApi = jsonGoLoginApi;
        this.tokenProvider = tokenProvider;
    }

    public Completable logIn(LoginUserDTO loginUserDTO) {

        return Completable.fromSingle(jsonGoLoginApi
                .postUserLogin(loginUserDTO)
                .doOnSuccess(tokenData -> {
                    tokenProvider.setPref(tokenData.getToken());
                })
                .subscribeOn(Schedulers.io())

        );
    }

}
