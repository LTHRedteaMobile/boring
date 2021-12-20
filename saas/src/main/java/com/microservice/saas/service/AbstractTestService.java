package com.microservice.saas.service;

import java.util.Objects;

/**
 * @author Alex Liu
 * @date 2021/09/07
 */
public abstract class AbstractTestService {

    public ObsService obsService;

    public void print() {
        System.out.println(Objects.isNull(obsService));
    }
}
