package com.wgc.myannotation.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)  // 约束注解应用的时机
@Documented
@Constraint(
        validatedBy = {PasswordValidate.class} // 与约束注解关联的验证器
)
public @interface Verification {

    String message() default "密码的格式不正确";   // 约束注解验证时的输出消息

    /**
     * @return
     * */
    String pwd() default "[a-zA-Z0-9]{*}";

    Class<?>[] groups() default { };       // 约束注解在验证时所属的组别

    Class<? extends Payload>[] payload() default { }; // 约束注解的有效负载
}
