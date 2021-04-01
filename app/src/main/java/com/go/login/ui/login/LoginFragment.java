package com.go.login.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.go.login.App;
import com.go.login.R;
import com.go.login.data.network.JSONGoLoginApi;
import com.go.login.data.network.TokenProvider;
import com.go.login.usecases.GetCurrentUserUseCase;
import com.go.login.usecases.LoginUseCase;
import com.go.login.usecases.RegistrationUseCase;
import com.google.android.material.snackbar.Snackbar;


import javax.inject.Inject;

public class LoginFragment extends Fragment implements LoginContract.View {

    @Inject
    public LoginContract.Presenter loginPresenter;

    Button btn_singIn;
    TextView txt_createAccount;
    TextView txt_email;
    TextView txt_password;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        App.applicationComponent.inject(this);
        loginPresenter.start(this);

        txt_email = rootView.findViewById(R.id.txt_email);
        txt_password = rootView.findViewById(R.id.txt_password_login);

        btn_singIn = rootView.findViewById(R.id.btn_sign_in);
        btn_singIn.setOnClickListener(view ->
                loginPresenter.singIn(txt_email.getText().toString(),
                        txt_password.getText().toString())
        );

        txt_createAccount = rootView.findViewById(R.id.txt_create_account);
        txt_createAccount.setOnClickListener(view ->
                Navigation.findNavController(view)
                        .navigate(R.id.action_loginFragment_to_registrationFragment)
        );

        return rootView;
    }

    @Override
    public void toUserInfo() {
        NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_userInfoFragment);
    }

    @Override
    public void showError() {
        Snackbar.make(rootView, "Ошибка на сервере. Проверьте введённые данные и повторите попытку", Snackbar.LENGTH_SHORT).show();
    }
}