package com.example.springmvcexamples.example02.handlingexception.service;

import com.example.springmvcexamples.example02.handlingexception.exception.MyException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class Example02Service {
    public void addFile() {
        try {
            Files.readString(Path.of("A:/aa.aa"));
        } catch (IOException e) {
            throw new MyException("文件处理错误!" + e.getMessage());
        }
    }
}
