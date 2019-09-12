package com.newrank.webtest.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFieldAnnotation {
    String value() default "";
    String name() default "";
    String type() default "";
}
