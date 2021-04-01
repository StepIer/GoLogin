package com.go.login.ui.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.go.login.App;
import com.go.login.R;
import com.go.login.data.network.TokenProvider;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;


public class RegistrationFragment extends Fragment implements RegistrationContract.View {

    @Inject
    public RegistrationContract.Presenter registrationPresenter;

    Button btn_singUp;
    TextView txt_login;
    TextView txt_email;
    TextView txt_password;
    TextView txt_confirmPassword;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
    ) {

        rootView = inflater.inflate(R.layout.fragment_registration, container, false);
        App.applicationComponent.inject(this);
        registrationPresenter.start(this);

        txt_email = rootView.findViewById(R.id.txt_email);
        txt_password = rootView.findViewById(R.id.txt_password_registration);
        txt_confirmPassword = rootView.findViewById(R.id.txt_confirm_password);

        btn_singUp = rootView.findViewById(R.id.btn_sign_up);

        btn_singUp.setOnClickListener(view -> registrationPresenter.singUp(
                txt_email.getText().toString(),
                txt_password.getText().toString(),
                txt_confirmPassword.getText().toString()
        ));

        txt_login = rootView.findViewById(R.id.txt_log_in);
        txt_login.setOnClickListener(view ->
                Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment)
        );

        return rootView;
    }

    @Override
    public void showError() {
        Snackbar.make(rootView, "Ошибка на сервере. Проверьте введённые данные и повторите попытку", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void toUserInfo() {
        NavHostFragment.findNavController(this).navigate(R.id.action_registrationFragment_to_userInfoFragment);
    }
}