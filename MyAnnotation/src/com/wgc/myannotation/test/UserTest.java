package com.wgc.myannotation.test;

import com.wgc.myannotation.annotation.Validate;
import com.wgc.myannotation.entity.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class UserTest {

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {
        System.out.println(" ============ 方案一 =============== ");
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Validate.class)) {
                Validate annotation = field.getAnnotation(Validate.class);
                System.out.println(annotation.name());
            }
        }


        System.out.println(" =============== 方案二 ============== ");
        Field[] declaredFields = Class.forName("com.wgc.myannotation.entity.User").getDeclaredFields();
        Field name = User.class.getDeclaredField(declaredFields[0].getName());
        if (name.isAnnotationPresent(Validate.class)) {
            System.out.println(name.getAnnotation(Validate.class).name());
            for (Annotation annotation : name.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }
}
