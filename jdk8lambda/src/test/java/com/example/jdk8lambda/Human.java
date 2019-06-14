package com.example.jdk8lambda;

import lombok.Data;

/**
 * @author madengbo
 * @create 2019-04-18 15:02
 * @desc
 * @Version 1.0
 **/
public class Human {
    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human( String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int getAge() {
        return age;
    }

    public String setAge(int age) {
        this.age = age;
        return null;

    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}