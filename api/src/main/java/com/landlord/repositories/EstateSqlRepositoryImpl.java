package com.landlord.repositories;

import com.landlord.models.Estate;
import com.landlord.repositories.base.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstateSqlRepositoryImpl implements GenericRepository<Estate> {
    private final SessionFactory sessionFactory;

    @Autowired
    public EstateSqlRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAll() {
        List result;
        try (
                Session session = sessionFactory.openSession()
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
    public Estate getById(int id) {
        Estate result;
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.get(Estate.class, id);
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
            Estate estate = session.get(Estate.class, id);
            session.delete(estate);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Estate estate) {
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            session.save(estate);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Estate estate) {
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            Estate estateToChange = session.get(Estate.class, id);

            // lanlordID ....

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
