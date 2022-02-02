package ru.netology.homeworkspringbootrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.homeworkspringbootrest.authorities.Authorities;
import ru.netology.homeworkspringbootrest.exception.InvalidCredentials;
import ru.netology.homeworkspringbootrest.exception.UnauthorizedUser;
import ru.netology.homeworkspringbootrest.service.AuthorizationService;
import ru.netology.homeworkspringbootrest.user.User;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String invalidCredentialsHandle(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String unauthorizedUserHandle(UnauthorizedUser e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String constraintViolationExceptionHandle(ConstraintViolationException e) {
        return e.getMessage();
    }

}
