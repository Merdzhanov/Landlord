package com.landlord.android.diconfig;

import com.landlord.android.views.camera.CameraMainFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CameraModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CameraMainFragment CameraMainFragment();
}