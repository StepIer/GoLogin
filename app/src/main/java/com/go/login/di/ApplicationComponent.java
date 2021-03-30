package com.go.login.di;


import com.go.login.ui.login.FragmentLogin;
import com.go.login.data.network.NetworkService;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class, UseCaseModule.class})
public interface ApplicationComponent {

    void inject(NetworkService networkService);
    void inject(FragmentLogin fragmentLogin);




}
