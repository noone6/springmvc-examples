package com.example.springmvcexamples.example03.beanvalidation.controller;

import com.example.springmvcexamples.example03.beanvalidation.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example03")
@Validated
public class Example03Controller {

    @PostMapping("/users")
    public Map postUser(@Valid @RequestBody User user) {
        return Map.of();
    }

    @GetMapping("/users/{uid}/file")
    public void getTypeMismatchException(@PathVariable int uid) {
    }

    @GetMapping("/users/{onwer}")
    public void getViolationException(
            @Size(min = 2, max = 6, message = "用户信息错误")
            @PathVariable String onwer) {
    }


}
