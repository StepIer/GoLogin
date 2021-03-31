package com.go.login.ui.registration;

import android.view.View;

import com.go.login.ui.base.BasePresenter;
import com.go.login.ui.base.BaseView;

public interface RegistrationContract {
    interface View extends BaseView {
        void toLogin(android.view.View view);

    }
    interface Presenter extends BasePresenter {

        void start(View view);


        void singin(String email, String password);

    }
}
