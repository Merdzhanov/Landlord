package com.landlord.services.base;

import com.landlord.dto.ChatMessageDTO;
import com.landlord.dto.ChatMessageInputDTO;
import java.util.List;

public interface MessageService {
    List<ChatMessageDTO> getMessagesByEstateID(String estateID);
    void create(ChatMessageInputDTO chatMessageInputDTO);
}
