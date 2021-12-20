package com.microservice.saas.cglib;

import org.springframework.cglib.proxy.FixedValue;

/**
 * @author Alex Liu
 * @date 2021/05/20
 */
public class MyResultFix implements FixedValue {

    @Override
    public Object loadObject() throws Exception {
        return null;
    }
}
