package com.go.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.go.login.fragments.FragmentLogin;
import com.go.login.fragments.FragmentRegistration;

public class MainActivity extends AppCompatActivity {


    public static final String APP_PREFERENCES = "settingsForAutorization";
    public static final String APP_PREFERENCES_TOKEN = "Token";
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }

    public void setPref(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(APP_PREFERENCES_TOKEN, token);
        editor.apply();
    }

    public String getPref(){
        if(sharedPreferences.contains(APP_PREFERENCES_TOKEN)) {
            return sharedPreferences.getString(APP_PREFERENCES_TOKEN, "");
        }
        return "error";
    }


}