package com.microservice.saas.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Alex Liu
 * @date 2021/08/11
 */
@Slf4j
@Component
public class MyInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet ....");
    }
}
