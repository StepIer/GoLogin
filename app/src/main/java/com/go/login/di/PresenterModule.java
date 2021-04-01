package com.go.login.di;

import com.go.login.ui.login.LoginContract;
import com.go.login.ui.login.LoginPresenter;
import com.go.login.ui.registration.RegistrationPresenter;
import com.go.login.ui.registration.RegistrationContract;
import com.go.login.ui.userinfo.UserInfoContract;
import com.go.login.ui.userinfo.UserInfoPresenter;
import com.go.login.usecases.GetCurrentUserUseCase;
import com.go.login.usecases.LoginUseCase;
import com.go.login.usecases.RegistrationUseCase;

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

    @Singleton
    @Provides
    public RegistrationContract.Presenter provideRegistrationPresenter(RegistrationUseCase registrationUseCase) {
        return new RegistrationPresenter(registrationUseCase);
    }

    @Singleton
    @Provides
    public UserInfoContract.Presenter provideUserInfoPresenter(GetCurrentUserUseCase getCurrentUserUseCase) {
        return new UserInfoPresenter(getCurrentUserUseCase);
    }
}
