package com.landlord;

import com.landlord.models.User;
import com.landlord.repositories.base.GenericRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static com.landlord.models.base.UserType.LANDLORD;
import static com.landlord.models.base.UserType.TENANT;


@SpringBootApplication
public class ApiApplication {
    @Autowired
    public ApiApplication(GenericRepository<User> usersRepository) {
        List<User> initialUsers = Arrays.asList(
                new User("Rumi", 4.75, LANDLORD),
                new User("Kosio", 3.5, TENANT)
        );
        initialUsers
                .forEach(usersRepository::add);
    }
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}