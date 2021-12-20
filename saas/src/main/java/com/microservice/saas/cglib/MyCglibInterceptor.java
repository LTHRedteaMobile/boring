package com.microservice.saas.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Alex Liu
 * @date 2021/05/20
 */
public class MyCglibInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Log 1");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("log 2");
        return object;
    }
}
