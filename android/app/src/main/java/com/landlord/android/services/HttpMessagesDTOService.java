package com.landlord.android.services;

import com.landlord.android.models.ChatMessageDTO;
import com.landlord.android.repositories.base.Repository;
import com.landlord.android.services.base.MessagesDTOService;
import java.io.IOException;

public class HttpMessagesDTOService implements MessagesDTOService {

    private final Repository<ChatMessageDTO> mChatMessagesDTORepository;

    public HttpMessagesDTOService(
            Repository<ChatMessageDTO> mChatMessagesDTORepository) {
        this.mChatMessagesDTORepository=mChatMessagesDTORepository;
    }

    @Override
    public ChatMessageDTO createMessage(ChatMessageDTO Message) throws IOException {
        return mChatMessagesDTORepository.add(Message);
    }
}
