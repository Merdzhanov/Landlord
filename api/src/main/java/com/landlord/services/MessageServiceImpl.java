package com.landlord.services;

import com.landlord.dto.ChatMessageDTO;
import com.landlord.dto.ChatMessageInputDTO;
import com.landlord.repositories.base.MessagesRepository;
import com.landlord.services.base.GenericService;
import com.landlord.services.base.MessageService;
import com.landlord.utils.ChatMessageInputMapperImpl;
import com.landlord.utils.ChatMessageMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessagesRepository mMessagesRepository;
    private final ChatMessageMapperImpl mChatMessageMapper;
    private final ChatMessageInputMapperImpl mChatMessageInputMapper;
    private final GenericService mGenericService;

    @Autowired
    public MessageServiceImpl(MessagesRepository messagesRepository,
                              ChatMessageMapperImpl chatMessageMapper,
                              ChatMessageInputMapperImpl chatMessageInputMapper,
                              GenericService genericService
    ) {
        mMessagesRepository = messagesRepository;
        mChatMessageMapper = chatMessageMapper;
        mChatMessageInputMapper = chatMessageInputMapper;
        mGenericService = genericService;
    }

    @Override
    public List<ChatMessageDTO> getMessagesByEstateID(String estateID) {
        return mChatMessageMapper.mapMany(mMessagesRepository.getMessagesByEstateID(estateID));
    }

    @Override
    public void create(ChatMessageInputDTO chatMessageInputDTO) {
        mGenericService.create(mChatMessageInputMapper.map(chatMessageInputDTO));
    }

//    @Override
//    public List<ChatMessage>  getAllMessages() {
//        return this.landlordRepository.getAllMessages();
//    }

//    @Override
//    public List<ChatMessage> getMessagesByEstate(String estateName) {
//        return this.landlordRepository.getMessagesByEstate(estateName);
//    }

}
