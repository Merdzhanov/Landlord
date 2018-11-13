package com.landlord.repositories.base;

import com.landlord.models.ChatMessage;
import java.util.List;

public interface MessagesRepository{
    List<ChatMessage> getMessagesByEstateID(String estateID);
}
