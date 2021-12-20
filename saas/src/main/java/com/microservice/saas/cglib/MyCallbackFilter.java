package com.microservice.saas.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author Alex Liu
 * @date 2021/05/20
 */
public class MyCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("method1".equals(method.getName())) {
            return 0;
        }
        if ("method2".equals(method.getName())) {
            return 1;
        }
        return 2;
    }
}
