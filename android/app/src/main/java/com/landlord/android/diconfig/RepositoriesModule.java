package com.landlord.android.diconfig;

import com.landlord.android.http.HttpRequester;
import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.ChatMessageDTO;
import com.landlord.android.models.Estate;
import com.landlord.android.models.EstateDTO;
import com.landlord.android.models.RatingVoteDTO;
import com.landlord.android.models.User;
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

    @Provides
    @Singleton
    public Repository<EstateDTO> EstateDTORepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<EstateDTO> jsonParser
    ) {
        String url = baseServerUrl;// + "/Estates";
        return new HttpRepository<>(url,httpRequester,jsonParser);
    }

    @Provides
    @Singleton
    public Repository<ChatMessage> MessageRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<ChatMessage> jsonParser
    ) {
        String url = baseServerUrl; // + "/Messages";
        return new HttpRepository<>(url,httpRequester,jsonParser);
    }

    @Provides
    @Singleton
    public Repository<RatingVoteDTO> RatingVoteDTORepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<RatingVoteDTO> jsonParser
    ) {
        String url = baseServerUrl;
        return new HttpRepository<>(url,httpRequester,jsonParser);
    }
    @Provides
    @Singleton
    public Repository<ChatMessageDTO> DTOMessageRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<ChatMessageDTO> jsonParser
    ) {
        String url = baseServerUrl; // + "/Messages";
        return new HttpRepository<>(url,httpRequester,jsonParser);
    }

    @Provides
    @Singleton
    public Repository<User> UserRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<User> jsonParser
    ) {
        String url = baseServerUrl; // + "/Users";
        return new HttpRepository<>(url,httpRequester,jsonParser);
    }
}
