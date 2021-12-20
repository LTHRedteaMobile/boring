package com.microservice.saas.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * @author Alex Liu
 * @date 2021/05/20
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(MyClass.class.getSimpleName());
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyClass.class);
        enhancer.setCallbackFilter(new MyCallbackFilter());

        Callback callback1 = new MyCglibInterceptor();
        Callback callback2 = NoOp.INSTANCE;
        Callback fixedCallback = new MyResultFix();
        Callback[] callbacks = new Callback[]{callback1, fixedCallback, callback2};
        enhancer.setCallbacks(callbacks);
        MyClass test = (MyClass) enhancer.create();
        test.method1();
        System.out.println(test.method2());
        test.method3();
    }
}
