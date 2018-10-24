package com.landlord.android.diconfig;

import com.landlord.android.http.HttpRequester;
import com.landlord.android.models.Estate;
import com.landlord.android.parsers.base.JsonParser;
import com.landlord.android.repositories.HttpRepository;
import com.landlord.android.repositories.base.Repository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<Estate> EstateRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<Estate> jsonParser
    ) {
        String url = baseServerUrl;// + "/Estates";
        return new HttpRepository<>(url,httpRequester,jsonParser);
    }
}
