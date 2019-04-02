package com.example.springmvcexamples.example04.passwordencoder.service;

import com.example.springmvcexamples.example04.passwordencoder.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserService04 {
    private Map<String, User> map = new HashMap<>();
    public User getUser(String userName) {
        return map.get(userName);
    }
    public void addUser(User user) {
        map.put(user.getUserName(), user);
    }
}
