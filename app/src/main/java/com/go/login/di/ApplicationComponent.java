package com.go.login.di;

import com.go.login.ui.login.LoginFragment;
import com.go.login.data.network.NetworkService;
import com.go.login.ui.registration.RegistrationFragment;
import com.go.login.ui.userinfo.UserInfoFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class,
        ApplicationModule.class,
        UseCaseModule.class,
        PresenterModule.class
})
public interface ApplicationComponent {

    void inject(NetworkService networkService);

    void inject(LoginFragment loginFragment);

    void inject(RegistrationFragment registrationFragment);

    void inject(UserInfoFragment userInfoFragment);

}
