package com.microserice.db.service;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author Alex Liu
 * @date 2021/03/22
 */
@Service
@Conditional(S3ServiceCondition.class)
public class S3Service implements StorageService {

    @Override
    public void print() {
        System.out.println("S3Service");
    }
}
