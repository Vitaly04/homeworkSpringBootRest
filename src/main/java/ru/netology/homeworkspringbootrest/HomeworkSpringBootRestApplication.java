package ru.netology.homeworkspringbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.netology.homeworkspringbootrest.controller.AuthorizationController;
import ru.netology.homeworkspringbootrest.repository.UserRepository;
import ru.netology.homeworkspringbootrest.service.AuthorizationService;
import ru.netology.homeworkspringbootrest.user.User;
import ru.netology.homeworkspringbootrest.user.UserHandlerMethodArgumentResolver;

@SpringBootApplication
public class HomeworkSpringBootRestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HomeworkSpringBootRestApplication.class, args);

        AuthorizationService authorizationService = context.getBean(AuthorizationService.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = context.getBean(User.class);
        UserHandlerMethodArgumentResolver userHandlerMethodArgumentResolver = context.getBean(UserHandlerMethodArgumentResolver.class);

    }
}
