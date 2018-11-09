package com.landlord.android.services;

import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.ChatMessageDTO;
import com.landlord.android.repositories.base.Repository;
import com.landlord.android.services.base.MessagesDTOService;
import com.landlord.android.services.base.MessagesService;

import java.io.IOException;
import java.util.List;

public class HttpMessagesDTOService implements MessagesDTOService {

   // private final Repository<ChatMessage> mChatMessagesRepository;
    private final Repository<ChatMessageDTO> mChatMessagesDTORepository;


    public HttpMessagesDTOService(
           // Repository<ChatMessage> mChatMessagesRepository,
            Repository<ChatMessageDTO> mChatMessagesDTORepository) {
       // this.mChatMessagesRepository = mChatMessagesRepository;
        this.mChatMessagesDTORepository=mChatMessagesDTORepository;
    }


//    @Override
//    public List<ChatMessage> getAllMessages() throws IOException {
//        return mChatMessagesRepository.getAll();
//    }
//
//    @Override
//    public List<ChatMessage> getMessagesByEstate(String estateName) throws IOException {
//        return mChatMessagesRepository.getMessagesByEstate(estateName);
//    }

    @Override
    public ChatMessageDTO createMessage(ChatMessageDTO Message) throws IOException {
        return mChatMessagesDTORepository.add(Message);
    }

//    @Override
//    public List<ChatMessage> getMessagesByEstateID(Integer mEstateId) throws IOException {
//        return mChatMessagesRepository.getMessagesByEstateID(mEstateId);
//    }

}
