package com.newrank.webtest.aop;

import com.newrank.webtest.annotation.MyMethodAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.expression.EvaluationContext;

import java.lang.reflect.Method;

/**
 * @program: webtest
 * @description: 面向注解拦截
 * @author: ren
 * @create: 2019-06-19 09:35
 **/
@Component
@Aspect // 声明切面
@Slf4j
public class AspectTest {
    private ExpressionParser parser = new SpelExpressionParser();
    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Pointcut("@annotation(com.newrank.webtest.annotation.MyMethodAnnotation)")
    public void methodPointCount() {
    }

    @Before("methodPointCount()")
    public void pre(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyMethodAnnotation annotation = method.getAnnotation(MyMethodAnnotation.class);
        log.info(annotation.value() + " " + annotation.methodName());

        // 获取方法参数值
        Object[] arguments = joinPoint.getArgs();
        // 从注解中获取spel字符串，省略...
        String value = parseSpel(method,arguments,annotation.value(),String.class,null);
        log.info(value);
    }

//    @Pointcut("@annotation(com.newrank.webtest.annotation.MyParameterAnnotation)")
//    public void parameterPointCount() {
//    }
//
//    @Before("parameterPointCount()")
//    public void before(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        MyMethodAnnotation annotation = method.getAnnotation(MyMethodAnnotation.class);
//        log.info(annotation.value() + " " + annotation.methodName());
//    }

    /**
     * 解析 spel 表达式
     *
     * @param method    方法
     * @param arguments 参数
     * @param spel      表达式
     * @param clazz     返回结果的类型
     * @param defaultResult 默认结果
     * @return 执行spel表达式后的结果
     */
    private <T> T parseSpel(Method method, Object[] arguments, String spel, Class<T> clazz, T defaultResult) {
        String[] params = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], arguments[len]);
        }
        try {
            Expression expression = parser.parseExpression(spel);
            return expression.getValue(context, clazz);
        } catch (Exception e) {
            return defaultResult;
        }
    }
}
