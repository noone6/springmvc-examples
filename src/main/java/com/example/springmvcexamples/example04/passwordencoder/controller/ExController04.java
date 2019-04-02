package com.example.springmvcexamples.example04.passwordencoder.controller;

import com.example.springmvcexamples.example04.passwordencoder.entity.User;
import com.example.springmvcexamples.example04.passwordencoder.service.UserService04;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/example04")
public class ExController04 {
    @Autowired
    private UserService04 userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        String pwd = passwordEncoder.encode(user.getPassword());
        log.debug(pwd);
        user.setPassword(pwd);
        userService.addUser(user);
    }
    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> user) {
        // 先查询用户是否存在
        Optional.ofNullable(userService.getUser(user.get("userName")))
                .ifPresentOrElse(u -> {
                    // 用户存在，匹配加密
                    if (passwordEncoder.matches(user.get("password"), u.getPassword())) {
                        log.debug("用户存在且密码正确");
                    } else {
                        log.debug("用户存在但密码错误");
                    }
                },() -> log.debug("用户不存在"));
    }
}
