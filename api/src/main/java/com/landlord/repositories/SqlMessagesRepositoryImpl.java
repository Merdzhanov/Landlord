package com.landlord.repositories;

import com.landlord.models.ChatMessage;
import com.landlord.repositories.base.MessagesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlMessagesRepositoryImpl implements MessagesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ChatMessage> getMessagesByEstateID(String estateID) {
        List<ChatMessage> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("select elements(E.messageList) from Estate as E where E.id=:estateID")// and M.sender = E.id")
                    .setParameter("estateID", Integer.parseInt(estateID))
                    //.setMaxResults(300)
                    .list();
            session.getTransaction().commit();
        }
        return result;
    }
}