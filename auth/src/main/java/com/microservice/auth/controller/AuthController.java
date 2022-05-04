package com.microservice.auth.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex Liu
 * @date 2022/05/03
 */
@RestController
@RequestMapping("auth/api/v1/test")
public class AuthController {

    @GetMapping("/get")
    public ResponseEntity<String> testGet(@RequestParam("username") String username,
                                          @RequestParam("password") String password) throws Exception {
        throw new Exception("tttt");
        //return ResponseEntity.ok("auth get ok ... username is " + username + " password is " + password);
    }

    @PostMapping("/post")
    public ResponseEntity<String> testPost(@RequestBody JsonNode req) {
        return ResponseEntity.ok("auth post ok ... , req = " + req.toString());
    }
}
