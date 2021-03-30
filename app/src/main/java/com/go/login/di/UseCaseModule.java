package com.go.login.di;


import com.go.login.data.network.JSONGoLoginApi;
import com.go.login.data.network.TokenProvider;
import com.go.login.usecases.GetCurrentUserUseCase;
import com.go.login.usecases.LoginUseCase;
import com.go.login.usecases.RegistrationUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    public GetCurrentUserUseCase provideGetCurrentUserUseCase(JSONGoLoginApi jsonGoLoginApi, TokenProvider tokenProvider){
        return new GetCurrentUserUseCase(jsonGoLoginApi, tokenProvider);
    }
    @Provides
    public LoginUseCase provideLogInUseCase(JSONGoLoginApi jsonGoLoginApi, TokenProvider tokenProvider){
        return new LoginUseCase(jsonGoLoginApi, tokenProvider);
    }
    @Provides
    public RegistrationUseCase provideRegistrationUseCase(JSONGoLoginApi jsonGoLoginApi, TokenProvider tokenProvider){
        return new RegistrationUseCase(jsonGoLoginApi, tokenProvider);
    }

}
