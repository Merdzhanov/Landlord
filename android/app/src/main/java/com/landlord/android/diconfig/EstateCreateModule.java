package com.landlord.android.diconfig;

import com.landlord.android.views.EstateCreate.EstateCreateContracts;
import com.landlord.android.views.EstateCreate.EstateCreateFragment;
import com.landlord.android.views.EstateCreate.EstateCreatePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class EstateCreateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract EstateCreateFragment EstateCreateFragment();

    @ActivityScoped
    @Binds
    abstract EstateCreateContracts.Presenter EstateCreatePresenter(EstateCreatePresenter presenter);
}

