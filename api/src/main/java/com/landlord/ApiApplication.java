package com.landlord;

import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.User;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ApiApplication {
//    @Autowired
//    public ApiApplication(GenericRepository<User> usersRepository) {
//        List<User> initialUsers = Arrays.asList(
//                new User("Rumi", 4.75, LANDLORD),
//                new User("Kosio", 3.5, TENANT)
//        );
//        initialUsers
//                .forEach(usersRepository::add);
//    }
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(ChatMessage.class)
                .addAnnotatedClass(Estate.class)
                .buildSessionFactory();
    }

}