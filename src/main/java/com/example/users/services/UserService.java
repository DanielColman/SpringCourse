package com.example.users.services;

import com.example.users.models.User;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private Faker faker;

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User(faker.funnyName().name(), faker.name().username(), faker.internet().password()));
        users.add(new User(faker.funnyName().name(), faker.name().username(), faker.internet().password()));
        users.add(new User(faker.funnyName().name(), faker.name().username(), faker.internet().password()));
        users.add(new User(faker.funnyName().name(), faker.name().username(), faker.internet().password()));
        users.add(new User(faker.funnyName().name(), faker.name().username(), faker.internet().password()));
        users.add(new User(faker.funnyName().name(), faker.name().username(), faker.internet().password()));
        users.add(new User(faker.funnyName().name(), faker.name().username(), faker.internet().password()));
        users.add(new User(faker.funnyName().name(), faker.name().username(), faker.internet().password()));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUsersByUserName(String username) {
        return users.stream().filter(u->u.getUserName().equals(username))
                .findAny().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User %s not found ", username)));
    }
}
