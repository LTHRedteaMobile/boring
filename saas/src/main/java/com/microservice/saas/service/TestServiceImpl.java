package com.microservice.saas.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Alex Liu
 * @date 2021/09/07
 */
@Service
@Slf4j
public class TestServiceImpl extends AbstractTestService{

    @Autowired
    private ObsService obsService;

    @PostConstruct
    private void init() {
        super.obsService = obsService;
    }
}
