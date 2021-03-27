package com.go.login.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.go.login.MainActivity;
import com.go.login.R;

public class FragmentRegistration extends Fragment {


    Button login;


    static FragmentRegistration newInstance(){
        return new FragmentRegistration();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);


        login = rootView.findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.action_registrationFragment_to_loginFragment);

            }
        });

        return rootView;
    }
}