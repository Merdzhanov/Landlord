package com.landlord.api;

import com.landlord.dto.ChatMessageInputDTO;
import com.landlord.dto.EstateDTO;
import com.landlord.models.Estate;
import com.landlord.models.User;
import com.landlord.services.base.*;
import com.landlord.utils.ChatMessageInputMapperImpl;
import com.landlord.utils.EstateMapperImpl;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    Date date = new Date();

    EstateDTO estate;
    Estate estate1;
    User user;


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ChatMessagesApiController msgController;

    @Autowired
    private EstatesApiController estateController;

    @Autowired
    private RatingVotesApiController ratingController;

    @Autowired
    private UsersApiController userController;

    @Autowired
    EstateService estateService;

    @Autowired
    MessageService msgService;

    @Autowired
    RatingVoteService ratingService;

    @Autowired
    UserService userService;

    @Autowired
    GenericService genericService;

    @Autowired
    private ChatMessageInputMapperImpl chatMessageInputMapper;

    @Autowired
    EstateMapperImpl estateMapper;

    @Mock
    private ChatMessageInputDTO message;


//    @Test
//    public void add_NewMessageEntry_ShouldAddMessageEntry() throws Exception {
//        message = new MessageBuilder()
//                .message("test")
//                .estateId("1")
//                .username("Rumi")
//                .build();
//        AssertionsForClassTypes.assertThat(msgController.createChatMessage(message)).isNotNull();
//    }


//    @Test
//    public void When_Vote_add_NewRatingVoteEntry_ShouldAddMessageEntry() throws Exception {
//        RatingVoteDTO ratingVoteCreated;
//        ratingVoteCreated = new RatingVoteDTO(4, "Rumi", "Kosio");
//        AssertionsForClassTypes.assertThat(ratingController.createOrUpdateRatingVote(ratingVoteCreated)).isNotNull();
//    }


    @Test
    public void contexLoadsMsg() throws Exception {
        AssertionsForClassTypes.assertThat(msgController).isNotNull();
    }

    @Test
    public void contexLoadsEst() throws Exception {
        AssertionsForClassTypes.assertThat(estateController).isNotNull();
    }

    @Test
    public void contexLoadsUsr() throws Exception {
        AssertionsForClassTypes.assertThat(userController).isNotNull();
    }

    @Test
    public void contexLoadsRtng() throws Exception {
        AssertionsForClassTypes.assertThat(ratingController).isNotNull();
    }


    @Test
    public void contexLoadsUsersByUserName() throws Exception {
        AssertionsForClassTypes.assertThat(userController.getUserByUsername("Rumi")).isNotNull();
    }

    @Test
    public void contexLoadsUsersbyUserId() throws Exception {
        AssertionsForClassTypes.assertThat(estateController.getEstatesByUser("Rumi")).isNotNull();
    }

    @Test
    public void contexLoadsEstatesById() throws Exception {
        AssertionsForClassTypes.assertThat(estateController.getEstatesByID(1)).isNotNull();
    }

//    @Test
//    public void EstatesUpdate() throws Exception {
//        EstateDTO estateForUpdate = this.estateService.getEstateByID(1);
//        estateForUpdate.setImage(estateForUpdate.getImage());
//        AssertionsForClassTypes.assertThat(estateController.updateEstate(estateMapper.map(estateForUpdate))).isNotNull();
//    }

    @Test
    public void contexLoadsMessagesByEstateID() throws Exception {
        AssertionsForClassTypes.assertThat(msgController.getMessagesByEstateID("1")).isNotNull();
    }

}