package com.go.login.ui.registration;

import android.util.Log;

import com.go.login.Config;
import com.go.login.data.entity.RegistrationData;
import com.go.login.usecases.RegistrationUseCase;
import com.google.android.material.snackbar.Snackbar;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import retrofit2.HttpException;

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private final RegistrationUseCase registrationUseCase;


    public RegistrationPresenter(RegistrationUseCase registrationUseCase) {
        this.registrationUseCase = registrationUseCase;
    }

    RegistrationContract.View view;

    @Override
    public void start(RegistrationContract.View view) {
        this.view = view;
    }

    @Override
    public void singUp(String email, String password, String confirmPassword) {
        registrationUseCase.registration(new RegistrationData(email, password, confirmPassword, Config.GOOGLE_ID))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    view.toUserInfo();

                }, throwable -> {
                    view.showError();
                });
    }

}
