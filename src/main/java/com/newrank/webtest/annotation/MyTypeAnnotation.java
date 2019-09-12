package com.newrank.webtest.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyTypeAnnotation {
    String value() default "";
    String className() default "";
}
