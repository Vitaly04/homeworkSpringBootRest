package ru.netology.homeworkspringbootrest.repository;

import ru.netology.homeworkspringbootrest.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<Authorities> authorities = new ArrayList<>(List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE));
    public List<Authorities> getUserAuthorities(String user, String password) {
        return (user.equals("karl") && password.equals("1234")) ? authorities : new ArrayList<>();
    }
}
