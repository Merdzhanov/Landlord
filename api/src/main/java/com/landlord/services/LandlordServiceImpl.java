package com.landlord.services;

import com.landlord.dto.RatingVoteDTO;
import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.RatingVote;
import com.landlord.models.User;
import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.GenericRepository;
import com.landlord.services.base.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LandlordServiceImpl implements LandlordService {

    private final GenericRepository<ModelBase> landlordRepository;

    @Autowired
    public LandlordServiceImpl(GenericRepository<ModelBase> landlordRepository) {
        this.landlordRepository = landlordRepository;
    }

    @Override
    public ChatMessage create(ModelBase item) {
        this.landlordRepository.create(item);
        return (ChatMessage) item;
    }

    @Override
    public List<User> getAllUsers() {
        return this.landlordRepository.getAllUsers();
    }

    @Override
    public User getByUserName(String userName) {
        return this.landlordRepository.getByUserName(userName);
    }

    @Override
    public RatingVote CreateRatingVoteByUsersVoterAndVotedFor(RatingVoteDTO ratingVoteDTO) {
        String voterUserName=ratingVoteDTO.getVoterUsername();
        String votedForUsername=ratingVoteDTO.getVotedForUserUsername();
        User votedForUser=getByUserName(votedForUsername);
        RatingVote ratingVoteToReturn=this.landlordRepository.getRatingVoteByUsersVoterAndVotedFor(voterUserName,votedForUsername);
        if(ratingVoteToReturn==null){
            ratingVoteToReturn=new RatingVote();
            ratingVoteToReturn.setVoter(getByUserName(voterUserName));
            ratingVoteToReturn.setVotedForUser(votedForUser);
        }
        ratingVoteToReturn.setRatingVoted(ratingVoteDTO.getRatingVoted());
        ratingVoteToReturn.setVotingDate(new Date());

        votedForUser.setRating(landlordRepository.getAverageRatingForUserByUsername(votedForUsername));
        return ratingVoteToReturn;
    }

    @Override
    public List<Estate> getAllEstates() {
        return this.landlordRepository.getAllEstates();
    }

    @Override
    public List<Estate> getEstatesByUser(String userName) {
        return this.landlordRepository.getEstatesByUser(userName);
    }

    @Override
    public Estate getEstateByID(int id) {
        return this.landlordRepository.getEstateByID(id);
    }

    @Override
    public ModelBase getById(int id) {
        return this.getById(id);
    }

    @Override
    public void update(int id, ModelBase item) {
        this.landlordRepository.update(id, item);
    }

    @Override
    public void delete(int id) {
        this.landlordRepository.delete(id);
    }

    @Override
    public List<ChatMessage>  getAllMessages() {
        return this.landlordRepository.getAllMessages();
    }

    @Override
    public List<ChatMessage> getMessagesByEstate(String estateName) {
        return this.landlordRepository.getMessagesByEstate(estateName);
    }

    @Override
    public List<ChatMessage> getMessagesByEstateID(String estateID) {
        return this.landlordRepository.getMessagesByEstateID(estateID);
    }


}
