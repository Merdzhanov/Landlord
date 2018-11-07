package com.landlord.android.services.base;

import com.landlord.android.models.ChatMessage;

import java.io.IOException;
import java.util.List;

public interface MessagesService {

    List<ChatMessage> getAllMessages() throws IOException;

    List<ChatMessage> getMessagesByEstate(String estateName) throws IOException;

    ChatMessage createMessage(ChatMessage Message) throws IOException;

    List<ChatMessage> getMessagesByEstateID(Integer mEstateId) throws IOException;
}
