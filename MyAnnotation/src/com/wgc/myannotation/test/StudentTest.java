package com.wgc.myannotation.test;

import com.wgc.myannotation.annotation.Name;
import com.wgc.myannotation.entity.Student;

import java.lang.reflect.Method;
/*
* 获取到方法的值
*
* */
public class StudentTest {

    public static void main(String[] args) {
        Method[] methods = Student.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Name.class)) {
                Name annotation = method.getAnnotation(Name.class);
                System.out.println(annotation.lastName());
                System.out.println(annotation.firstName());

            }
        }
    }
}
