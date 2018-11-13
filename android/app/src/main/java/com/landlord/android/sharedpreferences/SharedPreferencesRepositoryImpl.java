package com.landlord.android.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.landlord.android.sharedpreferences.base.SharedPreferencesRepository;

public class SharedPreferencesRepositoryImpl  implements SharedPreferencesRepository {

    private SharedPreferences prefs;

    public SharedPreferencesRepositoryImpl(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public String whoIsLoggedIn() {
        return prefs.getString("username", "");
    }
}
