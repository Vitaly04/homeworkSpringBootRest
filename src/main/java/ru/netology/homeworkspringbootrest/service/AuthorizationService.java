package ru.netology.homeworkspringbootrest.service;

import lombok.AllArgsConstructor;
import ru.netology.homeworkspringbootrest.authorities.Authorities;
import ru.netology.homeworkspringbootrest.exception.InvalidCredentials;
import ru.netology.homeworkspringbootrest.exception.UnauthorizedUser;
import ru.netology.homeworkspringbootrest.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}