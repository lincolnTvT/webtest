package com.newrank.webtest.aop;

import com.newrank.webtest.beans.ModelAndView;
import com.newrank.webtest.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: webtest
 * @description: 全局异常拦截器
 * @author: ren
 * @create: 2019-06-21 14:22
 **/
@RestControllerAdvice
public class InterceptException {
    // 全局异常拦截器
    @ExceptionHandler(CustomException.class)
    public ModelAndView rollbackExceptionHandler(HttpServletRequest req, Exception ex){
        CustomException customException = (CustomException) ex;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setSuccess(true);
        modelAndView.setValue(customException.getCode());
        return modelAndView;
    }

    // 全局数据绑定
    @ModelAttribute(name = "md")
    public Map<String,Object> mydata() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("gender", "男");
        return map;
    }
}
