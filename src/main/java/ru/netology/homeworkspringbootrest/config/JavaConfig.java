package ru.netology.homeworkspringbootrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.netology.homeworkspringbootrest.repository.UserRepository;
import ru.netology.homeworkspringbootrest.service.AuthorizationService;
import ru.netology.homeworkspringbootrest.user.User;
import ru.netology.homeworkspringbootrest.user.UserHandlerMethodArgumentResolver;

import java.util.List;

@Configuration
public class JavaConfig extends WebMvcConfigurerAdapter {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthorizationService authorizationService(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public User user() {
        return new User();
    }
    @Bean
    public UserHandlerMethodArgumentResolver userHandlerMethodArgumentResolver() {
        return new UserHandlerMethodArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserHandlerMethodArgumentResolver());
    }
}
