package com.landlord.api;


import com.landlord.dto.UserDTO;
import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.User;
import com.landlord.models.base.UserType;
import com.landlord.repositories.base.GenericRepository;
import com.landlord.services.base.MessageService;
import com.landlord.services.base.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ServicesTests {

    @Autowired
    GenericRepository repository;

    @Mock
    UserService service;

    private Estate defaultTestEstateInput;
    private Date date = new Date();

    private List<User> defaultTestUserInput = Arrays.asList(
            new User(1, "alex", (float) 3.75, UserType.TENANT),
            new User(2, "jessy",(float) 4.25, UserType.LANDLORD));


    private List<ChatMessage> defaultTestMessagesInput = Arrays.asList(
            new ChatMessage("first message", defaultTestEstateInput, defaultTestUserInput.get(0)),
            new ChatMessage("second message", defaultTestEstateInput, defaultTestUserInput.get(1)),
            new ChatMessage("third message", defaultTestEstateInput, defaultTestUserInput.get(0)));
    private ChatMessage message;

//    public ServicesTests() {
//        defaultTestEstateInput = new Estate("description", "address", defaultTestUserInput, (BigDecimal) 350.00, (BigDecimal) 420.25, date, defaultTestMessagesInput);
//    }


    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        // Arrange
        when(service.getByUserName("alex"))
                .thenReturn(defaultTestUserInput.get(0));

        // Act
        List<User> list = Collections.singletonList(service.getByUserName(defaultTestUserInput.get(0).getUserName()));
        int size = list.size();

        // Assert
        Assert.assertEquals(1, size);
        Assert.assertEquals(defaultTestUserInput.get(0).getUserName(), list.get(0).getUserName());
    }

    @Test
    public void whenNotValidName_thenEmployeeShouldBeNull() {
        // Arrange
        when(service.getByUserName("rumi"))
                .thenReturn(defaultTestUserInput.get(0));

        // Act
        List<User> list = Collections.singletonList(service.getByUserName("NotValidName"));
        int size = list.size();

        // Assert
        Assert.assertEquals(1, size);
        Assert.assertEquals(null, list.get(0));

        // Assert
//        assertThat(found.getUserName())
//                .isEqualTo(defaultTestUserInput.get(0).getUserName());
    }

}
