package com.go.login.di;

import com.go.login.ui.login.LoginContract;
import com.go.login.ui.login.LoginPresenter;
import com.go.login.usecases.LoginUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Singleton
    @Provides
    public LoginContract.Presenter provideLoginPresenter(LoginUseCase loginUseCase) {
        return new LoginPresenter(loginUseCase);
    }

//    @Singleton
//    @Provides
//    public RegistrationPresenter provideLoginPresenter() {
//        return new LoginPresenter();
//    }
}
