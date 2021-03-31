package com.go.login.ui.login;

import com.go.login.ui.base.BasePresenter;
import com.go.login.ui.base.BaseView;

public interface LoginContract  {
    interface View extends BaseView {

        void toUserInfo();
    }
    interface Presenter extends BasePresenter {

        void start(View view);


        void singIn(String email, String password);


    }
}
