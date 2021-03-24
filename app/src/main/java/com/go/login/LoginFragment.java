package com.go.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LoginFragment extends Fragment {

    static LoginFragment newInstance() {
        return new LoginFragment();
    }

    Button registration;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);


        registration = rootView.findViewById(R.id.button);

        registration.setOnClickListener(v -> ((MainActivity) requireActivity()).navigateToRegistration());

        return rootView;
    }
}