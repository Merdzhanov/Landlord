package com.landlord.android.diconfig;


import com.landlord.android.views.EstatesList.EstatesListContracts;
import com.landlord.android.views.EstatesList.EstatesListFragment;
import com.landlord.android.views.EstatesList.EstatesListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class EstatesListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract EstatesListFragment EstatesListFragment();

    @ActivityScoped
    @Binds
    abstract EstatesListContracts.Presenter EstatesListPresenter(EstatesListPresenter presenter);
}
