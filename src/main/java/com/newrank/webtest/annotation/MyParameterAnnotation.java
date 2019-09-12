package com.newrank.webtest.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyParameterAnnotation {
    String type() default "";
    String name() default "";
}
