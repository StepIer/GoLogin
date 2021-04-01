package com.go.login;

import android.app.Application;

import com.go.login.di.ApplicationComponent;
import com.go.login.di.ApplicationModule;
import com.go.login.di.DaggerApplicationComponent;

public class App extends Application {

    public static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}

