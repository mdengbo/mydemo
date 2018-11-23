package com.example.myproxy.cglibproxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author madengbo
 * @create 2018-11-23 15:38
 * @desc cglib 是通过变改  .class 的字节码 （相当于继承父类（目标类）来反向代理目标类的方法、属性）
 * @Version 1.0
 **/
public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
        System.err.println("=======before======");
        Object res = proxy.invokeSuper(obj, params);
        System.err.println("=======and======");
        return res;
    }
}
