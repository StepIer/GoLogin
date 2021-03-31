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

import com.go.login.App;
import com.go.login.R;
import com.go.login.data.network.JSONGoLoginApi;
import com.go.login.data.network.TokenProvider;
import com.go.login.data.entity.RegistrationData;
import com.go.login.data.entity.TokenData;
import com.go.login.ui.MainActivity;
import com.go.login.usecases.GetCurrentUserUseCase;
import com.go.login.usecases.LoginUseCase;
import com.go.login.usecases.RegistrationUseCase;


import javax.inject.Inject;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;


public class LoginFragment extends Fragment implements LoginContract.View {

    static LoginFragment newInstance() {
        return new LoginFragment();
    }


    //Dagger

    @Inject
    public JSONGoLoginApi jsonGoLoginApi;
    @Inject
    public TokenProvider tokenProvider;
    @Inject
    public GetCurrentUserUseCase getCurrentUserUseCase;
    @Inject
    public RegistrationUseCase registrationUseCase;
    @Inject
    public LoginUseCase loginUseCase;
    @Inject
    public LoginContract.Presenter loginPresenter;

    Button get;
    Button post_user;
    Button post_user_login;
    TextView textView;
    TokenData tokenData = null;
    TextView prefText;
    Button registration;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        App.applicationComponent.inject(this);
        loginPresenter.start(this);


        MainActivity mainActivity = (MainActivity) this.getActivity();





        registration.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registrationFragment));


        get.setOnClickListener(v -> getCurrentUserUseCase.getUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userEntity -> {

                    if (userEntity != null) {
                        textView.append(userEntity.getId() + "\n");
                        textView.append(userEntity.getCreatedAt() + "\n");
                        textView.append(userEntity.getEmail() + "\n");
                        textView.append(userEntity.getHasTrial() + "\n");
                        textView.append(userEntity.getNeedCard() + "\n");
                        textView.append(userEntity.getPlan() + "\n");
                        textView.append(userEntity.getTrialDays() + "\n");
                    }
                }));
        post_user.setOnClickListener(v -> {

            RegistrationData registrationData = new RegistrationData("email_test1@mail.ru", "pass_test", "pass_test", "google_client_test1");


            registrationUseCase.registration(registrationData)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(() -> {

                    }, throwable -> {

                    });


        });
        post_user_login.setOnClickListener(v -> {
           // LoginUserDTO loginUserDTO = new LoginUserDTO("email_test@mail.ru", "pass_test", true, "google_client_test");
            loginPresenter.singIn("email_test@mail.ru", "pass_test");
        });
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        loginPresenter.stop();
    }

    @Override
    public void toUserInfo() {
        Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show();
    }
}