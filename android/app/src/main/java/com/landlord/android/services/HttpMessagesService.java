package com.landlord.android.services;

import com.landlord.android.models.ChatMessage;
import com.landlord.android.repositories.base.Repository;
import com.landlord.android.services.base.MessagesService;

import java.io.IOException;
import java.util.List;

public class HttpMessagesService implements MessagesService {

    private final Repository<ChatMessage> mChatMessagesRepository;

    public HttpMessagesService(Repository<ChatMessage> mChatMessagesRepository) {
        this.mChatMessagesRepository = mChatMessagesRepository;
    }


    @Override
    public List<ChatMessage> getAllMessages() throws IOException {
        return mChatMessagesRepository.getAll();
    }

    @Override
    public List<ChatMessage> getMessagesByEstate(String estateName) throws IOException {
        return mChatMessagesRepository.getMessagesByEstate(estateName);
    }

    @Override
    public ChatMessage createMessage(ChatMessage Message) throws IOException {
        return mChatMessagesRepository.add(Message);
    }

    @Override
    public List<ChatMessage> getMessagesByEstateID(Integer mEstateId) throws IOException {
        return mChatMessagesRepository.getMessagesByEstateID(mEstateId);
    }

}
