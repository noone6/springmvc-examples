package com.example.springmvcexamples.example01;

import com.example.springmvcexamples.example01.entity.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example01")
public class Example01Controller {

    @GetMapping("/login")
    public Map getIndex() {
        return Map.of("name", "BO");
    }
    @GetMapping("/addresses")
    public Map getAddresses() {
        Address a1 = new Address(1, "956");
        Address a2 = new Address(2, "925");
        Address a3 = new Address(3, "1121");
        return Map.of("addresses", List.of(a1, a2, a3));
    }
    @PostMapping("/addresses")
    public Map postLogin(@RequestBody Address address) {
        log.debug("{}", address.getDetail());
        address.setInsertTime(LocalDateTime.now());
        return Map.of("address", address);
    }

    @GetMapping("/news/{nid}")
    public Map getNews(@PathVariable int nid) {
        log.debug("{}", nid);
        return Map.of("nid", nid);
    }
    @GetMapping("/repos/{owner}/{repo}/issues/{number}/comments")
    public void getComments(@PathVariable String owner,
                            @PathVariable String repo,
                            @PathVariable int number) {
        log.debug("owner: {}; repo: {}; number: {}", owner, repo, number);
    }

    @GetMapping("/addresses/{aid}")
    public Map getAddress(@PathVariable int aid) {
        Address address = new Address(1, "956");
        address.setInsertTime(LocalDateTime.now());
        return Map.of("address", address);
    }
    @PatchMapping("/addresses/{aid}")
    public Map patchAddress(@RequestBody Address address) {
        log.debug("userID: {}", address.getUser().getId());
        return Map.of("address", address);
    }

}
