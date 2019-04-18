package com.example.jdk8lambda;

import lombok.Data;

/**
 * @author madengbo
 * @create 2019-04-18 15:02
 * @desc
 * @Version 1.0
 **/
@Data
public class Human {
    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human(final String name, final int age) {
        super();

        this.name = name;
        this.age = age;
    }
}