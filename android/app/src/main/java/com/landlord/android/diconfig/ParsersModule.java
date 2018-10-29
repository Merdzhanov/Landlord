package com.landlord.android.diconfig;

import com.landlord.android.models.Estate;
import com.landlord.android.models.User;
import com.landlord.android.parsers.GsonJsonParser;
import com.landlord.android.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<Estate> EstateJsonParser() {
        return new GsonJsonParser<>(Estate.class, Estate[].class);
    }
    @Provides
    public JsonParser<User> UserJsonParser() {
        return new GsonJsonParser<>(User.class, User[].class);
    }
}
