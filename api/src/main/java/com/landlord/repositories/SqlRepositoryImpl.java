package com.landlord.repositories;

import com.landlord.models.Estate;
import com.landlord.models.User;
import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlRepositoryImpl implements GenericRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void create(ModelBase item) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
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

    @Override
    public List<Estate> getAllEstates() {
        List<Estate> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from Estate").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Estate> getEstatesByUser(String userName) {
        List<Estate> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            User user=getByUserName(userName);
            //result=user.getEstates();
            result = session.createQuery("select Estate from Estate as E, User as U where U.userName=:userName")
                    //.setParameter("user", getByUserName(userName))
                    .setParameter("userName", userName)
                    .list();

            session.getTransaction().commit();
        }
        return result;

    }

    @Override
    public Estate getEstateByID(int id) {
        Estate result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Estate.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ModelBase getById(int id) {
        ModelBase result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(ModelBase.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;

    }

    @Override
    public void update(int id, ModelBase item) {

    }

    @Override
    public void delete(int id) {

    }
}