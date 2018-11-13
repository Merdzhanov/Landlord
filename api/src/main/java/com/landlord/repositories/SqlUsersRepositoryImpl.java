package com.landlord.repositories;

import com.landlord.models.User;
import com.landlord.repositories.base.UsersRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SqlUsersRepositoryImpl implements UsersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getByUserName(String userName) {
        User result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = (User) session.createQuery("from User where userName = :userName")
                    .setParameter("userName", userName)
                    .getSingleResult();
            session.getTransaction().commit();
        }
        ///result..setRating(getAverageRatingForUserByUsername(votedForUsername));
        return result;
    }
//    @Override
//    public List<User> getAllUsers() {
//        List<User> result = new ArrayList<>();
//        try (
//                Session session = sessionFactory.openSession();
//        ) {
//            session.beginTransaction();
//            result = session.createQuery("from User").list();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//        }
//        return result;
//
//    }
}