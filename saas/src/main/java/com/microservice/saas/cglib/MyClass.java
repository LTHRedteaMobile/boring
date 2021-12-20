package com.microservice.saas.cglib;

/**
 * @author Alex Liu
 * @date 2021/05/20
 */
public class MyClass {

    public void method1() {
        System.out.println("it's method 1");
    }

    public Object method2() {
        System.out.println("it's method 2");
        return new Object();
    }

    public void method3() {
        System.out.println("it's method 3");
    }
}
