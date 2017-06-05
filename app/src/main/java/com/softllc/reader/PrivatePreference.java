package com.softllc.reader;

import android.content.Context;
import android.content.SharedPreferences;

public class PrivatePreference {

    private PrivatePreference() {
        //throw(new Exception("invalid use of private constructor"));
    }

    private SharedPreferences mSharedPreferences;

    public PrivatePreference(Context context, String name) {
        mSharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public Float getFloat(String key, Float def) {
        return mSharedPreferences.getFloat(key, def);
    }

    public Float putFloat(String key, Float value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
        return value;

    }

    public Boolean getBoolean(String key, Boolean def) {
        return mSharedPreferences.getBoolean(key, def);
    }

    public Boolean putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
        return value;
    }
}
