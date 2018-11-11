package com.landlord.android.diconfig;

import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.ChatMessageDTO;
import com.landlord.android.models.Estate;
import com.landlord.android.models.EstateDTO;
import com.landlord.android.models.RatingVoteDTO;
import com.landlord.android.models.User;
import com.landlord.android.repositories.base.Repository;
import com.landlord.android.services.HttpEstatesDTOService;
import com.landlord.android.services.HttpEstatesService;
import com.landlord.android.services.HttpMessagesDTOService;
import com.landlord.android.services.HttpMessagesService;
import com.landlord.android.services.HttpRatingVoteDTOService;
import com.landlord.android.services.HttpUsersService;
import com.landlord.android.services.base.EstatesDTOService;
import com.landlord.android.services.base.EstatesService;
import com.landlord.android.services.base.MessagesDTOService;
import com.landlord.android.services.base.MessagesService;
import com.landlord.android.services.base.RatingVoteDTOService;
import com.landlord.android.services.base.UsersService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public EstatesService EstatesService(Repository<Estate> repository) {
        return new HttpEstatesService(repository);
    }

    @Provides
    public EstatesDTOService EstatesDTOService(Repository<EstateDTO> repository) {
        return new HttpEstatesDTOService(repository);
    }

    @Provides
    public MessagesService MessagesService(Repository<ChatMessage> repository) {
        return new HttpMessagesService(repository);
    }

    @Provides
    public MessagesDTOService MessagesDTOService(Repository<ChatMessageDTO> repositoryDTO) {
        return new HttpMessagesDTOService(repositoryDTO);
    }
    @Provides
    public RatingVoteDTOService RatingVoteDTOService(Repository<RatingVoteDTO> repositoryDTO) {
        return new HttpRatingVoteDTOService(repositoryDTO);
    }


    @Provides
    public UsersService UsersService(Repository<User> repository) {
        return new HttpUsersService(repository);
    }
}
