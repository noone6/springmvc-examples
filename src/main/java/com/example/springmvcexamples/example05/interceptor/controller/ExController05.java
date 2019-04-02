package com.example.springmvcexamples.example05.interceptor.controller;

import com.example.springmvcexamples.example05.interceptor.component.EncryptorComponent05;
import com.example.springmvcexamples.example05.interceptor.component.ObjectMapperComponent05;
import com.example.springmvcexamples.example05.interceptor.exception.UnauthorizedException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example05")
public class ExController05 {
    @Autowired
    private EncryptorComponent05 encryptorComponent;
    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> user, HttpServletResponse response) {
        if ("BO".equals(user.get("userName"))) {
            // 模拟登录成功
            Map<String, Object> map = new HashMap<>();
            map.put("uid", 1);
            map.put("aid", 1);
            // 生成加密token
            String token = encryptorComponent.encrypt(map);
            log.debug(token);
            // 在header创建自定义的权限
            response.setHeader("Authorization", token);
        } else {
            // 如果登录失败，抛出权自定义限异常
            throw new UnauthorizedException();
        }
    }
    @GetMapping("/index")
    public Map getIndex() {
        return Map.of("index", "main");
    }
}
