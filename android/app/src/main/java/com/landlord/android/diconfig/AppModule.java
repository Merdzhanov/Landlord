package com.landlord.android.diconfig;

import android.app.Application;
import android.content.Context;

import com.landlord.android.sharedpreferences.SharedPreferencesRepositoryImpl;
import com.landlord.android.sharedpreferences.base.SharedPreferencesRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {
    @Binds
    abstract Context bindContext(Application application);
}


