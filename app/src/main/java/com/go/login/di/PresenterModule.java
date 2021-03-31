package com.go.login.di;

import com.go.login.ui.login.LoginContract;
import com.go.login.ui.login.LoginBasePresenter;
import com.go.login.ui.registration.RegistrationBasePresenter;
import com.go.login.ui.registration.RegistrationContract;
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
        return new LoginBasePresenter(loginUseCase);
    }

    @Singleton
    @Provides
    public RegistrationContract.Presenter provideRegistrationPresenter(RegistrationUseCase registrationUseCase) {
        return new RegistrationBasePresenter(registrationUseCase);
    }
}
