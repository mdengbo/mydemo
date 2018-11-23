package com.example.myproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author madengbo
 * @create 2018-11-23 15:18
 * @desc  jdkproxy 是通过实现共同的接口 来反向代理
 * @Version 1.0
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.err.println("------begin----------");
        method.invoke(target, args);
        System.err.println("------end----------");
        return null;

    }
}
