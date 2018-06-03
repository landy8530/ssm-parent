package com.landy.ssm.aop.exception;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface LogAnnotation {

    String value() default "";
    
}
