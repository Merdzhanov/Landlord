package com.landlord.api;


import com.landlord.dto.*;
import com.landlord.services.base.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ChatMessagesApiController {
    private final MessageService mMessageService;

    @Autowired
    public ChatMessagesApiController(
            MessageService messageService
    ) {
        mMessageService = messageService;
    }

    @RequestMapping(
            value = "/Messages/Estate/ID/{estateID}",
            method = RequestMethod.GET
    )
    public List<ChatMessageDTO> getMessagesByEstateID(@PathVariable("estateID") String estateID) {
        return mMessageService.getMessagesByEstateID(estateID);
    }

    @RequestMapping(
            value = "Messages/add",
            method = RequestMethod.POST
    )
    public void createChatMessage(@RequestBody ChatMessageInputDTO chatMessageInputDTO) {
        mMessageService.create(chatMessageInputDTO);
    }

    //    @RequestMapping(
//            path = "Messages",
//            method = RequestMethod.GET
//    )
//    public List<ChatMessageDTO> getAllMessages() {
//        List<ChatMessage> models = this.landlordService.getAllMessages();
//        return this.chatMessageMapper.mapMany(models);
//    }

//    @RequestMapping(
//            value = "Messages/Estate/{estateName}",
//            method = RequestMethod.GET
//    )
//    public List<ChatMessageDTO> getMessagesByEstate(@PathVariable("estateName") String estateName) {
//        List<ChatMessage> models = this.landlordService.getMessagesByEstate(estateName);
//        return this.chatMessageMapper.mapMany(models);
//    }
}
