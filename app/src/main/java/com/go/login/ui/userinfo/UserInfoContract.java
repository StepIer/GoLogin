package com.go.login.ui.userinfo;

import android.view.View;

import com.go.login.ui.base.BasePresenter;
import com.go.login.ui.base.BaseView;
import com.go.login.ui.registration.RegistrationContract;

public interface UserInfoContract {
    interface View extends BaseView {
        void showUserInfo();

    }
    interface Presenter extends BasePresenter {
        void start(View view);
    }
}
