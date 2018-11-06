package com.landlord.android.diconfig;

import com.landlord.android.views.MessagesList.MessagesListContracts;
import com.landlord.android.views.MessagesList.MessagesListFragment;
import com.landlord.android.views.MessagesList.MessagesListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MessagesListModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MessagesListFragment MessagesListFragment();

    @ActivityScoped
    @Binds
    abstract MessagesListContracts.Presenter MessagesListPresenter(MessagesListPresenter presenter);
}