package com.landlord.repositories;

import com.landlord.models.User;
import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlRepository  implements GenericRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public ModelBase findById(String id) {
        ModelBase result=null;
        try(
                Session session = sessionFactory.openSession()
                )
        {
            session.beginTransaction();
            result = session.get(User.class, id);
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public void add(ModelBase user) {

    }
}
