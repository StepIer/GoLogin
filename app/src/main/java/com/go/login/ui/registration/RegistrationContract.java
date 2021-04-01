package com.go.login.ui.registration;


public interface RegistrationContract {
    interface View{

        void showError();

        void toUserInfo();

    }
    interface Presenter{

        void start(View view);

        void singUp(String email, String password, String confirmPassword);

    }
}
