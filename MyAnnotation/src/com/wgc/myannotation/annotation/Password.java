package com.wgc.myannotation.annotation;

import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)  // 约束注解应用的时机
@Documented
public @interface Password {

    String message() default "密码的格式不正确";   // 约束注解验证时的输出消息

    String pwd() default "http://.*";

    Class<?>[] groups() default { };       // 约束注解在验证时所属的组别

    Class<? extends Payload>[] payload() default { }; // 约束注解的有效负载
}
