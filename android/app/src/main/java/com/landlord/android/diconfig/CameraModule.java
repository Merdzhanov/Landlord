package com.landlord.android.diconfig;

import com.landlord.android.views.MessagesList.MessagesListContracts;
import com.landlord.android.views.MessagesList.MessagesListFragment;
import com.landlord.android.views.MessagesList.MessagesListPresenter;
import com.landlord.android.views.camera.CameraMainFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CameraModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract CameraMainFragment CameraMainFragment();

//    @ActivityScoped
//    @Binds
//    abstract MessagesListContracts.Presenter MessagesListPresenter(MessagesListPresenter presenter);
}