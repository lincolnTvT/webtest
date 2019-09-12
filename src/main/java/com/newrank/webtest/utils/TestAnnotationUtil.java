package com.newrank.webtest.utils;

import com.newrank.webtest.annotation.MyFieldAnnotation;
import com.newrank.webtest.annotation.MyMethodAnnotation;
import com.newrank.webtest.annotation.MyParameterAnnotation;
import com.newrank.webtest.annotation.MyTypeAnnotation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: webtest
 * @description: 用于测试自定义注解的工具类
 * @author: ren
 * @create: 2019-06-19 09:12
 **/
//@Data
@Slf4j
//@MyTypeAnnotation(value = "test", className = "TestAnnotationUtil.class")
//@Component
public class TestAnnotationUtil {
    @MyFieldAnnotation(value = "lincoln", type = "String", name = "name")
    private String name;
    @MyFieldAnnotation(value = "24", type = "int", name = "age")
    private int age;
    @MyMethodAnnotation(value = "#doing",methodName = "doSomething")
    public void doSomething(String doing) {
        log.info("{} is {},is {}",name,age,doing);
    }

    public void testParameter(@MyParameterAnnotation String name){
        log.info(name);
    }
}
