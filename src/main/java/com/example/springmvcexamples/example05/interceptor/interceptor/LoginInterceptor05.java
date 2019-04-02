package com.example.springmvcexamples.example05.interceptor.interceptor;

import com.example.springmvcexamples.example05.interceptor.component.EncryptorComponent05;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Component
public class LoginInterceptor05 extends HandlerInterceptorAdapter {
    @Autowired
    private EncryptorComponent05 encryptorComponent;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .or(() -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录！");
                })
                .map(token -> {
                    var map = encryptorComponent.decrypt(token);
                    request.setAttribute("uid", Integer.valueOf(map.get("uid").toString()));
                    request.setAttribute("aid", Integer.valueOf(map.get("aid").toString()));
                    return true;
                })
                // header不存在Authorization
                .orElse(false);
    }
}
