package com.landlord.api;


import com.landlord.dto.*;
import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.RatingVote;
import com.landlord.models.User;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.ChatMessageInputMapperImpl;
import com.landlord.utils.ChatMessageMapperImpl;
import com.landlord.utils.EstateMapperImpl;
import com.landlord.utils.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class LandlordApiController {
    private final LandlordService landlordService;
    private final UserMapperImpl userMapper;
    private final EstateMapperImpl estateMapper;
    private final ChatMessageMapperImpl chatMessageMapper;
    private ChatMessageInputMapperImpl chatMessageInputMapper;


    @Autowired
    public LandlordApiController(
            LandlordService landlordService,
            UserMapperImpl userMapper,
            EstateMapperImpl estateMapper,
            ChatMessageMapperImpl chatMessageMapper,
            ChatMessageInputMapperImpl chatMessageInputMapper
    ) {
        this.landlordService = landlordService;
        this.userMapper = userMapper;
        this.estateMapper = estateMapper;
        this.chatMessageMapper = chatMessageMapper;
        this.chatMessageInputMapper=chatMessageInputMapper;
    }

    @RequestMapping(
            path = "Users",
            method = RequestMethod.GET
    )
    public List<UserDTO> getAllUsers() {
        List<User> models = this.landlordService.getAllUsers();
        return this.userMapper.mapMany(models);
    }

    @RequestMapping(
            path = "/Users/Username/{userName}",
            method = RequestMethod.GET
    )
    public UserDTO getUserByUsername(@PathVariable("userName") String userName) {
        User models = this.landlordService.getByUserName(userName);
        return this.userMapper.map(models);
    }

    @RequestMapping(
            path = "Estates",
            method = RequestMethod.GET
    )
    public List<EstateDTO> getAllEstates() {
        List<Estate> models = this.landlordService.getAllEstates();
        return this.estateMapper.mapMany(models);
    }

    @RequestMapping(
            value = "Estates/User/{userName}",
            method = RequestMethod.GET
    )
    public List<EstateDTO> getEstatesByUser(@PathVariable("userName") String userName) {
        List<Estate> models = this.landlordService.getEstatesByUser(userName);
        return this.estateMapper.mapMany(models);
    }

    @RequestMapping(
            value = "Estates/ID/{id}",
            method = RequestMethod.GET
    )
    public EstateDTO getEstatesByID(@PathVariable("id") int id) {
        Estate estate = this.landlordService.getEstateByID(id);
        return this.estateMapper.map(estate);
    }

    @RequestMapping(
            value = "Rating/add",
            method = RequestMethod.POST
    )
    public ResponseEntity<RatingVote> createRatingVote(@RequestBody RatingVoteDTO ratingVoteDTO) {
         RatingVote ratingVoteCreated = this.landlordService.CreateRatingVoteByUsersVoterAndVotedFor(ratingVoteDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ratingVoteCreated);
    }

    @RequestMapping(
            value = "Messages/add",
            method = RequestMethod.POST
    )
    public ResponseEntity<ChatMessageDTO> createChatMessage(@RequestBody ChatMessageInputDTO chatMessageInputDTO) {
    //public void createChatMessageDTO(@RequestBody ChatMessageDTO chatMessageDTO) {
        ChatMessage model = this.chatMessageInputMapper.map(chatMessageInputDTO);
        ChatMessage chatMessage = this.landlordService.create(model);
        ChatMessageDTO dtoToReturn = this.chatMessageMapper.map(chatMessage);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(dtoToReturn);
    }

    @RequestMapping(
            value = "Estates/update",
            method = RequestMethod.PUT
    )
    public ResponseEntity<Estate> updateEstate(@RequestBody Estate estateInput) {
        int id=estateInput.getId();
        Estate estate = this.landlordService.getEstateByID(id);
        estate.setImage(estateInput.getImage());

        return ResponseEntity.status(HttpStatus.OK)
                .body(estate);
    }

    @RequestMapping(
            path = "Messages",
            method = RequestMethod.GET
    )
    public List<ChatMessageDTO> getAllMessages() {
        List<ChatMessage> models = this.landlordService.getAllMessages();
        return this.chatMessageMapper.mapMany(models);
    }

    @RequestMapping(
            value = "Messages/Estate/{estateName}",
            method = RequestMethod.GET
    )
    public List<ChatMessageDTO> getMessagesByEstate(@PathVariable("estateName") String estateName) {
        List<ChatMessage> models = this.landlordService.getMessagesByEstate(estateName);
        return this.chatMessageMapper.mapMany(models);
    }

    @RequestMapping(
            value = "/Messages/Estate/ID/{estateID}",
            method = RequestMethod.GET
    )
    public List<ChatMessageDTO> getMessagesByEstateID(@PathVariable("estateID") String estateID) {
        List<ChatMessage> models = this.landlordService.getMessagesByEstateID(estateID);
        return this.chatMessageMapper.mapMany(models);
    }
}
