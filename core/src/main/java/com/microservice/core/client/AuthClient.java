package com.microservice.core.client;

import com.microservice.core.fallback.AuthFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Alex Liu
 * @date 2022/05/03
 */
@FeignClient(name = "auth", url = "http://localhost:8080", fallback = AuthFallback.class)
public interface AuthClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/auth/test/get")
    String get(@RequestParam("username") String username, @RequestParam("password") String password);
}
