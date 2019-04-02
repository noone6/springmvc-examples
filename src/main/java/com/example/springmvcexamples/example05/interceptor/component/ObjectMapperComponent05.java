package com.example.springmvcexamples.example05.interceptor.component;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class ObjectMapperComponent05 {
    @Autowired
    private ObjectMapper mapper;
    public String writeValueAsString(Map payload) {
        try {
            return mapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
        }
        return null;
    }

    public Map<String, Object> readValue(String json) {
        try {
            return mapper.readValue(json, Map.class);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录！");
        }
    }
}
