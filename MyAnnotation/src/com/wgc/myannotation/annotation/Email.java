package com.wgc.myannotation.annotation;

import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})   // 约束注解应用的目标元素类型(METHOD, FIELD, TYPE, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER等)
@Retention(RetentionPolicy.RUNTIME)  // 约束注解应用的时机
@Documented
public @interface Email {

    String message() default "这不是有效的电子邮件格式";   // 约束注解验证时的输出消息

    Class<?>[] groups() default { };  // 约束注解在验证时所属的组别

    Class<? extends Payload>[] payload() default { }; // 约束注解的有效负载

    /**
     * 邮箱的验证规则
     * @return
     */
    String regexp() default "[^a-z]";

    @Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})   // 约束注解应用的目标元素类型(METHOD, FIELD, TYPE, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER等)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        Email[] value();
    }
}
