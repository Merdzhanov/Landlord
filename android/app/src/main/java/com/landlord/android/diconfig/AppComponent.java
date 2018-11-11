package com.landlord.android.diconfig;

import android.app.Application;

import com.landlord.android.LandlordApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        ParsersModule.class,
        HttpModule.class,
        RepositoriesModule.class,
        ServicesModule.class,
        AsyncModule.class,
        ViewsModule.class,
        MessagesListModule.class,
        CameraModule.class
})
public interface AppComponent extends AndroidInjector<LandlordApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
