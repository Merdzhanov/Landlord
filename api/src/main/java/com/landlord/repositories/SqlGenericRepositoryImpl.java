package com.landlord.repositories;

import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.GenericRepository;
import com.landlord.utils.FieldCopyUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

//    @Override
//    public T getById(int id) {
//        T result = null;
//        try (
//                Session session = sessionFactory.openSession();
//        ) {
//            session.beginTransaction();
//            result = session.get(T.class, id);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//        }
//        return result;
//
//    }

    @Override
    public void update(int id, ModelBase item) {
        ModelBase object = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            object = session.get(ModelBase.class, id);
            FieldCopyUtil.setFields(item, object);
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        ModelBase object = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            object = session.get(ModelBase.class, id);
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}