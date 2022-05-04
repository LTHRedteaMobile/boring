package com.microservice.core.controller;

import com.microservice.core.client.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex Liu
 * @date 2021/03/24
 */
@RestController
@RequestMapping("core/api/v1/test")
public class TestController {

    @Autowired
    private AuthClient authClient;

    @GetMapping("getAuth")
    public ResponseEntity<String> auth() {
        return ResponseEntity.ok(authClient.get("1111", "22222"));
    }

}
