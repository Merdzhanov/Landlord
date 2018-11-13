package com.landlord.android.diconfig;

import com.landlord.android.views.Login.LoginContracts;
import com.landlord.android.views.Login.LoginPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginModule {
    @ActivityScoped
    @Binds
    abstract LoginContracts.Presenter LoginPresenter(LoginPresenter presenter);
}