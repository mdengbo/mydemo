package com.example.myproxy.jdkproxy;

/**
 * @author madengbo
 * @create 2018-11-23 15:17
 * @desc
 * @Version 1.0
 **/
public class EnglishService implements PeopleService{
    @Override
    public void sayHello() {
        System.out.println("Hi~");
    }

    @Override
    public void printName(String name) {
        System.err.println("Your name:" + name);
    }
}
