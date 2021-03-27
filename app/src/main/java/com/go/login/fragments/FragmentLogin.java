package com.go.login.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.go.login.MainActivity;
import com.go.login.R;


public class FragmentLogin extends Fragment {

    static FragmentLogin newInstance() {
        return new FragmentLogin();
    }

    Button registration;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);


        registration = rootView.findViewById(R.id.button);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registrationFragment);

            }
        });
        return rootView;
    }
}