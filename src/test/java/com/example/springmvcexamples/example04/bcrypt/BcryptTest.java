package com.example.springmvcexamples.example04.bcrypt;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class BcryptTest {
    @Test
    public void bcryptTest() {
        PasswordEncoder p = new BCryptPasswordEncoder();
        String password = "123456";
        log.debug(p.encode(password));
        log.debug(p.encode(password));
        String result = p.encode(password);
        log.debug("{}", p.matches("123456", result));
        log.debug("{}", p.matches("123457", result));
    }
}
