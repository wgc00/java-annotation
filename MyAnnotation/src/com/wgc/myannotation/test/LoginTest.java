package com.wgc.myannotation.test;

import com.wgc.myannotation.annotation.Email;
import com.wgc.myannotation.annotation.Password;
import com.wgc.myannotation.entity.Login;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class LoginTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
     /*   *//*  基于spring mvc 框架的 *//*
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator =  validatorFactory.getValidator();
        Login login = new Login("上", "234");
        Set<ConstraintViolation<Login>> validate = validator.validate(login);
        System.out.println(validate.iterator().next().getMessage());
*/
        Login login = new Login("1","http://1234");
        Field[] declaredFields = Class.forName("com.wgc.myannotation.entity.Login").getDeclaredFields();
       // System.out.println(declaredFields[1].getName());
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Email.class)) {
                Email annotation = field.getAnnotation(Email.class);
                //System.out.println(annotation);
                String regexp = annotation.regexp();
                System.out.println(regexp);
                if (login.getEmail().matches(regexp)) {
                    System.out.println("这是正确的邮箱");
                } else {
                    System.out.println(annotation.message());
                }
                System.out.println(login.getEmail().matches(regexp));
            }
            if (field.isAnnotationPresent(Password.class)) {
                System.out.println(field.getAnnotation(Password.class).pwd());
                String pwd = field.getAnnotation(Password.class).pwd();
                if (login.getPassword().matches(pwd)) {
                    System.out.println("正确");

                } else  {
                    System.out.println(field.getAnnotation(Password.class).message());
                }
                for (Annotation annotation : field.getAnnotations()) {
                    //System.out.println(annotation);


                }
            }

        }



    }
}
