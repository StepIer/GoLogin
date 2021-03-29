package com.go.login.di;


import com.go.login.fragments.FragmentLogin;
import com.go.login.network.NetworkService;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class})
public interface ApplicationComponent {

    void inject(NetworkService networkService);
    void inject(FragmentLogin fragmentLogin);




}
