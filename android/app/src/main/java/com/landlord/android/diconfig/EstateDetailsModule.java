package com.landlord.android.diconfig;

import com.landlord.android.views.EstateDetails.EstateDetailsContracts;
import com.landlord.android.views.EstateDetails.EstateDetailsFragment;
import com.landlord.android.views.EstateDetails.EstateDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class EstateDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract EstateDetailsFragment EstateDetailsFragment();

    @ActivityScoped
    @Binds
    abstract EstateDetailsContracts.Presenter EstatesListPresenter(EstateDetailsPresenter presenter);
}