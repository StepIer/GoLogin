package com.go.login.ui.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.go.login.R;

public class RegistrationFragment extends Fragment {


    Button login;


    static RegistrationFragment newInstance(){
        return new RegistrationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);


        login = rootView.findViewById(R.id.btn_sign_in);

        login.setOnClickListener(v -> {

           // Navigation.findNavController(v).navigate(R.id.action_registrationFragment_to_loginFragment);

        });

        return rootView;
    }
}