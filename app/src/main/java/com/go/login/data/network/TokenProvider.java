package com.go.login.data.network;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenProvider {
    private static final String APP_PREFERENCES = "settingsForAutorization";
    private static final String APP_PREFERENCES_TOKEN = "Token";
    private final SharedPreferences sharedPreferences;

    public TokenProvider(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void setPref(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(APP_PREFERENCES_TOKEN, token);
        editor.apply();
    }

    public String getPref() {
        return sharedPreferences.getString(APP_PREFERENCES_TOKEN, "error");
    }
}
