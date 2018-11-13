package com.landlord.repositories;

import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.RatingVote;
import com.landlord.models.User;
import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.GenericRepository;
import com.landlord.repositories.base.RatingVotesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlRatingVotesRepositoryImpl implements RatingVotesRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public RatingVote getRatingVoteByUsersVoterAndVotedFor(String voterUserName, String votedForUsername) {
        List<RatingVote> ratingVotels;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();

            ratingVotels = session.createQuery("from RatingVote as RV where RV.voter=:voterUserName and RV.votedForUser.userName=:votedForUsername")
                    .setParameter("voterUserName", voterUserName)
                    .setParameter("votedForUsername", votedForUsername)
                    .list();

            session.getTransaction().commit();
        }
        if (ratingVotels.isEmpty()){
            return null;
        }else {
            return ratingVotels.get(0);
        }
    }

    @Override
    public float getAverageRatingForUserByUsername(String votedForUsername) {
        float averageRating= 0;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();

            averageRating = session.createQuery("select AVG (RV.ratingVoted) from RatingVote as RV where RV.votedForUser.userName=:votedForUsername")
                    .setParameter("votedForUsername", votedForUsername)
                    .getFirstResult();

            session.getTransaction().commit();
        }

        return averageRating;
    }
}