package com.landlord.android.diconfig;

import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.ChatMessageDTO;
import com.landlord.android.models.Estate;
import com.landlord.android.models.EstateDTO;
import com.landlord.android.models.RatingVoteDTO;
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
    public JsonParser<EstateDTO> EstateDTOJsonParser() {
        return new GsonJsonParser<>(EstateDTO.class, EstateDTO[].class);
    }
    @Provides
    public JsonParser<User> UserJsonParser() {
        return new GsonJsonParser<>(User.class, User[].class);
    }

    @Provides
    public JsonParser<ChatMessage> MessageJsonParser() {
        return new GsonJsonParser<>(ChatMessage.class, ChatMessage[].class);
    }

    @Provides
    public JsonParser<RatingVoteDTO> RatingVoteDTOJsonParser() {
        return new GsonJsonParser<>(RatingVoteDTO.class, RatingVoteDTO[].class);
    }

    @Provides
    public JsonParser<ChatMessageDTO> DTOMessageJsonParser() {
        return new GsonJsonParser<>(ChatMessageDTO.class, ChatMessageDTO[].class);
    }
}
