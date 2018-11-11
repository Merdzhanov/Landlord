package com.landlord.api;

import com.landlord.dto.ChatMessageInputDTO;
import com.landlord.dto.EstateDTO;
import com.landlord.dto.UserDTO;
import com.landlord.models.ChatMessage;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.ChatMessageInputMapperImpl;
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

    private static final Object date = new Date().getTime();

    EstateDTO estate;
    UserDTO user;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LandlordApiController controller;

    @Autowired
    LandlordService landlordService;

    @Autowired
    private ChatMessageInputMapperImpl chatMessageInputMapper;

    @Mock
    private ChatMessageInputDTO message;

    @Test
    public void add_NewMessageEntry_ShouldAddMessageEntry() throws Exception {
        message = new MessageBuilder()
                .message("test")
                .estateId("1")
                .username("Rumi")
                .build();
        AssertionsForClassTypes.assertThat(controller.createChatMessage(message)).isNotNull();
    }

    @Test
    public void contexLoads() throws Exception {
        AssertionsForClassTypes.assertThat(controller).isNotNull();
    }

    @Test
    public void contexLoadsUsers() throws Exception {
        AssertionsForClassTypes.assertThat(controller.getAllUsers()).isNotNull();
    }

    @Test
    public void contexLoadsEstates() throws Exception {
        AssertionsForClassTypes.assertThat(controller.getAllEstates()).isNotNull();
    }

    @Test
    public void contexLoadsMessages() throws Exception {
        AssertionsForClassTypes.assertThat(controller.getAllMessages()).isNotNull();
    }

    @Test
    public void contexLoadsUsersByUserId() throws Exception {
        AssertionsForClassTypes.assertThat(controller.getUserByUsername("Rumi")).isNotNull();
    }

    @Test
    public void contexLoadsUsersbyUserId() throws Exception {
        AssertionsForClassTypes.assertThat(controller.getEstatesByUser("Rumi")).isNotNull();
    }

    @Test
    public void contexLoadsEstatesById() throws Exception {
        AssertionsForClassTypes.assertThat(controller.getEstatesByID(1)).isNotNull();
    }

    @Test
    public void contexLoadsMessagesByEstate() throws Exception {
        AssertionsForClassTypes.assertThat(controller.getMessagesByEstate("Ednostaen")).isNotNull();
    }

    @Test
    public void contexLoadsMessagesByEstateID() throws Exception {
        AssertionsForClassTypes.assertThat(controller.getMessagesByEstateID("1")).isNotNull();
    }

}
