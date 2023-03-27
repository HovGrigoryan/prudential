package com.epam.prudential.controller;

import com.epam.prudential.mapper.UserMapper;
import com.epam.prudential.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;


    @GetMapping
    public User getUser() {
        return userMapper.getUser(1L);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userMapper.findAll();
    }

    @PostMapping("/update")
    public List<User> update(@RequestBody User user) {
        User updatedUser = User.builder()
                .name(user.getName())
                .surname(user.getSurname()).build();
        userMapper.insert(updatedUser);
        return userMapper.findAll();

    }
}
