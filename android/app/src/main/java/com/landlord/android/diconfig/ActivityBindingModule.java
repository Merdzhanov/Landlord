package com.landlord.android.diconfig;

import com.landlord.android.views.EstateCreate.EstateCreateActivity;
import com.landlord.android.views.EstateDetails.EstateDetailsActivity;
import com.landlord.android.views.EstatesList.EstatesListActivity;
import com.landlord.android.views.MessagesList.MessagesListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules = EstatesListModule.class
    )
    abstract EstatesListActivity estatesListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = EstateDetailsModule.class
    )
    abstract EstateDetailsActivity EstateDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = EstateCreateModule.class
    )
    abstract EstateCreateActivity EstateCreateActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = MessagesListModule.class
    )
    abstract MessagesListActivity messagesListActivity();

}