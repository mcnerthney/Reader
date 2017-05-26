package com.softllc.reader;

import android.content.Context;
import android.content.SharedPreferences;

public class PrivatePreference {

    private PrivatePreference() {
        //throw(new Exception("invalid use of private constructor"));
    }

    private SharedPreferences mSharedPreferences;

    public PrivatePreference(Context context, String name) {
        SharedPreferences mSharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public Float getFloat(String key, Float def) {
        return mSharedPreferences.getFloat(key, def);
    }

    public void putFloat(String key, Float value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();

    }

    public Boolean getBoolean(String key, Boolean def) {
        return mSharedPreferences.getBoolean(key, def);
    }

    public void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}
