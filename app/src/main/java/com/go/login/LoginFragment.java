package com.go.login;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class LoginFragment extends Fragment {

    static LoginFragment newInstance(){
        return new LoginFragment();
    }

    Button registration;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);


        registration = rootView.findViewById(R.id.button);
        textView = rootView.findViewById(R.id.text_login);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textView.setText("dsfvg");
                ((MainActivity)getActivity()).navigateRegistration();

            }
        });

        return rootView;
    }
}