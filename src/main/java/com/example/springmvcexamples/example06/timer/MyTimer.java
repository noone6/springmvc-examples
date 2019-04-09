package com.example.springmvcexamples.example06.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyTimer {
    @Scheduled(cron = "0 0 8 10 * ?")
    public void paySalary() {
      log.debug("Your salary has been paid!");
    }
}
