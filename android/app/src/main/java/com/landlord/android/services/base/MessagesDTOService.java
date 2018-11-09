package com.landlord.android.services.base;

import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.ChatMessageDTO;

import java.io.IOException;
import java.util.List;

public interface MessagesDTOService {

    //List<ChatMessage> getAllMessages() throws IOException;

    //List<ChatMessage> getMessagesByEstate(String estateName) throws IOException;

    ChatMessageDTO createMessage(ChatMessageDTO Message) throws IOException;

    //List<ChatMessage> getMessagesByEstateID(Integer mEstateId) throws IOException;
}
