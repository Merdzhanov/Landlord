package com.landlord.repositories;

import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.GenericRepository;
import com.landlord.utils.FieldCopyUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SqlGenericRepositoryImpl<T> implements GenericRepository {

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
    public void update(int id, ModelBase item) {
        ModelBase object = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            object = session.get(item.getClass(), id);
            FieldCopyUtil.setFields(item, object);
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(ModelBase object) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            object = session.get(object.getClass(), object.getId());
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}