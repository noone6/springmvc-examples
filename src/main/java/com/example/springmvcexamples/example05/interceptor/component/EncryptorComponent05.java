package com.example.springmvcexamples.example05.interceptor.component;


import com.example.springmvcexamples.example05.interceptor.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@Component
public class EncryptorComponent05 {
    @Value("${my.secretkey}")
    private String secretKey;
    @Value("${my.salt}")
    private String salt;
    @Autowired
    private ObjectMapperComponent05 oComponent;
    // 加密
    public String encrypt(Map payload) {
        String json = oComponent.writeValueAsString(payload);
        return Encryptors.text(secretKey, salt).encrypt(json);
    }
    // 解密
    public Map<String, Object> decrypt(String encryptString) {
        try {
            String json = Encryptors.text(secretKey, salt).decrypt(encryptString);
            return oComponent.readValue(json);
        } catch (Exception e) {
            throw new UnauthorizedException();
        }
    }
}
