package com.landlord.api;

import com.landlord.dto.ChatMessageInputDTO;

public class MessageBuilder {


    private ChatMessageInputDTO msg;

    public MessageBuilder() {
        msg = new ChatMessageInputDTO();
    }

    public MessageBuilder message(String text) {
        msg.setMessage(text);
        return this;
    }

    public MessageBuilder estateId(String estateId) {
        msg.setEstateId(estateId);
        return this;
    }

    public MessageBuilder username(String username) {
        msg.setMessageSenderUsername(username);
        return this;
    }

    public ChatMessageInputDTO build() {
        return msg;
    }

}
