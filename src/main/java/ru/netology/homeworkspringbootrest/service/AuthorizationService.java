package ru.netology.homeworkspringbootrest.service;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import ru.netology.homeworkspringbootrest.authorities.Authorities;
import ru.netology.homeworkspringbootrest.exception.InvalidCredentials;
import ru.netology.homeworkspringbootrest.exception.UnauthorizedUser;
import ru.netology.homeworkspringbootrest.repository.UserRepository;
import ru.netology.homeworkspringbootrest.user.User;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@AllArgsConstructor
public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(@Valid User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getName(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getName());
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