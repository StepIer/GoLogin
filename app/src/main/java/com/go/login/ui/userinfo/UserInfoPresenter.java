package com.go.login.ui.userinfo;


import com.go.login.usecases.GetCurrentUserUseCase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;

public class UserInfoPresenter implements UserInfoContract.Presenter{

    GetCurrentUserUseCase getCurrentUserUseCase;
    UserInfoContract.View view;
    Disposable getUserDisposable;

    public UserInfoPresenter(GetCurrentUserUseCase getCurrentUserUseCase) {
        this.getCurrentUserUseCase = getCurrentUserUseCase;
    }

    @Override
    public void start(UserInfoContract.View view) {
        this.view = view;
        getUserDisposable = getCurrentUserUseCase.getUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showUserInfo);
    }
}
