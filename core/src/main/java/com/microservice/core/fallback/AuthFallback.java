package com.microservice.core.fallback;

import com.microservice.core.client.AuthClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Alex Liu
 * @date 2022/05/03
 */
@Component
@Slf4j
public class AuthFallback implements AuthClient {

    @Override
    public String get(String username, String password) {
        log.error("call auth failed, username = [{}], password = [{}]", username, password);
        return "failed";
    }
}
