package com.wgc.myannotation.annotation;

import java.lang.annotation.*;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    String name();
}
