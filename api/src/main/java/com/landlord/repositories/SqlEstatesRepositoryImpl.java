package com.landlord.repositories;

import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.RatingVote;
import com.landlord.models.User;
import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.EstatesRepository;
import com.landlord.repositories.base.GenericRepository;
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

//    @Autowired
//
//    private final GenericRepository<ModelBase> mGenericRepository;
//    private final UserMapperImpl userMapper;
//
//    @Autowired
//    public GenericServiceImpl(GenericRepository<ModelBase> genericRepository,
//                              UserMapperImpl userMapper
//    ) {
//        this.mGenericRepository = genericRepository;
//        this.userMapper = userMapper;
//    }

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

    //    @Override
//    public List<Estate> getAllEstates() {
//        List<Estate> result = new ArrayList<>();
//        try (
//                Session session = sessionFactory.openSession();
//        ) {
//            session.beginTransaction();
//            result = session.createQuery("from Estate").list();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
}