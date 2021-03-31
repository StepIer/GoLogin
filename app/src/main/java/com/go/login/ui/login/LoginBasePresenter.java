package com.go.login.ui.login;


import com.go.login.data.entity.LoginUserDTO;
import com.go.login.usecases.LoginUseCase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class LoginBasePresenter implements LoginContract.Presenter {

    private final LoginUseCase loginUseCase;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LoginBasePresenter(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    LoginContract.View view;

    @Override
    public void start(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void singIn(String email, String password) {
        compositeDisposable.add(loginUseCase.logIn(new LoginUserDTO(email, password, true, "1234"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()->{
                    if(view!=null) {
                        view.toUserInfo();
                    }
                }));
    }

    @Override
    public void stop() {
        view = null;
    }
}