package com.go.login.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.go.login.R;
import com.go.login.network.ErrorRegistration;
import com.go.login.network.RegistrationData;
import com.go.login.network.NetworkService;
import com.go.login.network.TokenData;
import com.go.login.network.UserEntity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentLogin extends Fragment {

    static FragmentLogin newInstance() {
        return new FragmentLogin();
    }

    Button get;
    Button post_user;
    Button post_user_login;
    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);


        get = rootView.findViewById(R.id.btn_get);
        post_user = rootView.findViewById(R.id.btn_post_user);
        post_user_login = rootView.findViewById(R.id.btn_post_user_login);
        textView = rootView.findViewById(R.id.text_login);


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NetworkService.getInstance()
                        .getJSONApi()
                        .getUser()
                        .enqueue(new Callback<UserEntity>() {
                            @Override
                            public void onResponse(@NonNull Call<UserEntity> call, @NonNull Response<UserEntity> response) {
                                UserEntity user = response.body();

                                textView.append(user.getId() + "\n");
                                textView.append(user.getCreatedAt() + "\n");
                                textView.append(user.getEmail() + "\n");
                                textView.append(user.getHasTrial() + "\n");
                                textView.append(user.getNeedCard() + "\n");
                                textView.append(user.getPlan() + "\n");
                                textView.append(user.getTrialDays() + "\n");

                            }

                            @Override
                            public void onFailure(@NonNull Call<UserEntity> call, @NonNull Throwable t) {

                                textView.append("Error occurred while getting request!");
                                t.printStackTrace();
                            }
                        });

            }
        });
        post_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegistrationData registrationData = new RegistrationData("email_test@mail.ru", "pass_test", "pass_test", "google_client_test");
                TokenData tokenData;

                NetworkService.getInstance()
                        .getJSONApi()
                        .postUser(registrationData)
                        .enqueue(new Callback<TokenData>() {
                            @Override
                            public void onResponse(Call<TokenData> call, Response<TokenData> response) {

                                if (response.code() == 201) {
                                    TokenData tokenData = response.body();

                                    textView.append(tokenData.getId() + "\n");
                                    textView.append(tokenData.getAccessToken() + "\n");
                                    textView.append(tokenData.getRefreshToken() + "\n");
                                    textView.append(tokenData.getToken() + "\n");
                                } else {
                                    try {
                                        Log.v("Error code 400",response.errorBody().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<TokenData> call, Throwable t) {

                                textView.append("Error occurred while getting request!");
                                t.printStackTrace();
                            }

                        });

            }
        });
        post_user_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return rootView;
    }
}