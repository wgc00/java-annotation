package com.wgc.myannotation.entity;

import com.wgc.myannotation.annotation.Validate;

public class User {

    @Validate(name = "张三")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
