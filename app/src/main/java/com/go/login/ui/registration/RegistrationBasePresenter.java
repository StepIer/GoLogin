package com.go.login.ui.registration;

import com.go.login.data.entity.RegistrationData;
import com.go.login.usecases.RegistrationUseCase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

public class RegistrationBasePresenter implements RegistrationContract.Presenter {

    private final RegistrationUseCase registrationUseCase;


    public RegistrationBasePresenter(RegistrationUseCase registrationUseCase) {
        this.registrationUseCase = registrationUseCase;
    }

    RegistrationContract.View view;

    @Override
    public void start(RegistrationContract.View view) {
        this.view = view;
    }

    @Override
    public void singin(String email, String password) {
        registrationUseCase.registration(new RegistrationData(email, password, password, "1234"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                }, throwable -> {

                });
    }

    @Override
    public void stop() {
        view = null;
    }
}
