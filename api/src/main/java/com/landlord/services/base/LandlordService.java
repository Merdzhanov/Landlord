package com.landlord.services.base;

import com.landlord.dto.RatingVoteDTO;
import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.RatingVote;
import com.landlord.models.User;
import com.landlord.models.base.ModelBase;

import java.util.List;

public interface LandlordService <T extends ModelBase> {
        ChatMessage create(T item);

        List<User> getAllUsers();

        User getByUserName(String userName);

//    RatingVote getRatingVoteByUsersVoterAndVotedFor(String voterUserName, String votedForUsername);

//    RatingVote CreateRatingVoteByUsersVoterAndVotedFor(String voterUserName, String votedForUsername);

    RatingVote CreateRatingVoteByUsersVoterAndVotedFor(RatingVoteDTO ratingVoteDTO);

    List<Estate> getAllEstates();

        List<Estate> getEstatesByUser(String userName);

        Estate getEstateByID(int id);

        T getById(int id);

        void update(int id, T item);

        void delete(int id);

        List<ChatMessage>  getAllMessages();

        List<ChatMessage> getMessagesByEstate(String estateName);

    List<ChatMessage> getMessagesByEstateID(String estateID);


}
