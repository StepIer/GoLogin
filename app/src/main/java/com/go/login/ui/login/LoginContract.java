package com.go.login.ui.login;

public interface LoginContract  {
    interface View extends com.go.login.ui.base.View {

        void toUserInfo();
    }
    interface Presenter extends com.go.login.ui.base.Presenter {

        void start(View view);


        void singIn(String email, String password);


    }
}
