package com.landlord.android.diconfig;

import com.landlord.android.async.AsyncSchedulerProvider;
import com.landlord.android.async.base.SchedulerProvider;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
