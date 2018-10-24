package com.landlord.android.diconfig;

import com.landlord.android.models.Estate;
import com.landlord.android.repositories.base.Repository;
import com.landlord.android.services.HttpEstatesService;
import com.landlord.android.services.base.EstatesService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public EstatesService EstatesService(Repository<Estate> repository) {
        return new HttpEstatesService(repository);
    }
}
