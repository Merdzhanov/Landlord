package com.landlord.repositories;

import com.landlord.models.Estate;
import com.landlord.repositories.base.EstatesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlEstatesRepositoryImpl implements EstatesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Estate> getEstatesByUser(String userName) {
        List<Estate> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("select E from Estate as E ,User as U where U.userName=:userName and U in elements(E.users)")
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
}