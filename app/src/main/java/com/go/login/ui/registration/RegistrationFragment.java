package com.go.login.ui.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.go.login.App;
import com.go.login.R;
import com.go.login.data.network.JSONGoLoginApi;
import com.go.login.data.network.TokenProvider;
import com.go.login.ui.login.LoginContract;
import com.go.login.usecases.GetCurrentUserUseCase;
import com.go.login.usecases.LoginUseCase;
import com.go.login.usecases.RegistrationUseCase;

import javax.inject.Inject;

public class RegistrationFragment extends Fragment implements RegistrationContract.View {
    @Inject
    public TokenProvider tokenProvider;
    @Inject
    public RegistrationContract.Presenter registrationPresenter;





    Button login;


    static RegistrationFragment newInstance(){
        return new RegistrationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);
        App.applicationComponent.inject(this);


        login = rootView.findViewById(R.id.btn_sign_in);

        login.setOnClickListener(v -> {
            registrationPresenter.singin("email_test1@mail.ru", "pass_test");

        });

        return rootView;
    }

    @Override
    public void toLogin(View view) {
        Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment);
    }
}