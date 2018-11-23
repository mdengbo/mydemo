package com.example.myproxy;

import com.example.myproxy.cglibproxy.MyInterceptor;
import com.example.myproxy.cglibproxy.MyTarget;
import com.example.myproxy.jdkproxy.EnglishService;
import com.example.myproxy.jdkproxy.MyInvocationHandler;
import com.example.myproxy.jdkproxy.PeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyproxyApplicationTests {

    @Test
    public void contextLoads() {
    }

    //jdkproxy
    @Test
    public void jdkProxyTest() {
        MyInvocationHandler handler = new MyInvocationHandler(new EnglishService());
        PeopleService proxyService = (PeopleService) Proxy.newProxyInstance(
                                                                            MyproxyApplicationTests.class.getClassLoader(),
                                                                            new Class[] { PeopleService.class },
                                                                            handler);
        proxyService.sayHello();
    }

    //cglibproxy
    @Test
    public void cglibProxyTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyTarget.class);
        enhancer.setCallback(new MyInterceptor());
        MyTarget target = (MyTarget) enhancer.create();
        target.printName();
        System.out.println("proxy class name:" + target.getClass().getName()); }


}
