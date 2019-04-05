package com.wgc.myannotation.entity;

import com.wgc.myannotation.annotation.Name;

public class Student {

    @Name(firstName = "喜喜", lastName = "陈")
    public String getName() {
        return "";
    }
}
