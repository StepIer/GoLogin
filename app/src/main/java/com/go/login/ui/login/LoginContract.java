package com.go.login.ui.login;

public interface LoginContract  {
    interface View{

        void showError();

        void toUserInfo();
    }

    interface Presenter{

        void start(View view);

        void singIn(String email, String password);
    }
}
