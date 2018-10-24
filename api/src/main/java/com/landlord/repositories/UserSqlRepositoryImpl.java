package com.landlord.repositories;

import com.landlord.models.User;
import com.landlord.models.base.UserType;
import com.landlord.repositories.base.GenericRepository;
import com.landlord.repositories.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSqlRepositoryImpl implements GenericRepository<User>, UserRepository {

    private final SessionFactory sessionFactory;


    @Autowired
    public UserSqlRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAll() {
        List result;
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.createQuery("from User").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public User getById(int id) {
        User result;
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.get(User.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return  result;
    }

    @Override
    public void delete(int id) {
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(User user) {
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, User user) {
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            User userToChange = session.get(User.class, id);

            userToChange.setRating(user.getRating());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List getByType (UserType type) {
        List result;
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.createQuery("from User where userType = :userType")
                    .setParameter("userType", type)
                    .list();
            session.getTransaction().commit();
        }
        return result;
    }

    public User getByUserName(String userName) {
        User result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = (User) session.createQuery("from User where userName  = :userName")
                    .setParameter("userName", userName)
                    .getSingleResult();
            session.getTransaction().commit();
        }
        return result;

    }

}
