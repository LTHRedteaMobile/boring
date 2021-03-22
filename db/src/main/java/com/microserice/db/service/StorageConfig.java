/*
package com.microserice.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @author Alex Liu
 * @date 2021/03/22
 *//*

@Configuration
public class StorageConfig {

    @Autowired
    private ObsService obsService;
    @Autowired
    private S3Service s3Service;

    @Bean
    @Conditional(ObsServiceCondition.class)
    public StorageService obsService() {
        return obsService;
    }

    @Bean
    @Conditional(S3ServiceCondition.class)
    public StorageService s3Service() {
        return s3Service;
    }
}
*/
