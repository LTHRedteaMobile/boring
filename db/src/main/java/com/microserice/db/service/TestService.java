package com.microserice.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Alex Liu
 * @date 2021/03/22
 */
@Service
public class TestService {

    @Autowired
    private StorageService storageService;

    @PostConstruct
    private void init() {
        storageService.print();
    }
}
