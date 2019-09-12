package com.newrank.webtest.controller;

import com.newrank.webtest.beans.UserVo;
import com.newrank.webtest.exception.CustomException;
import com.newrank.webtest.utils.TestAnnotationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: webtest
 * @description: controller层
 * @author: ren
 * @create: 2019-06-18 13:54
 **/
@RestController
@RequestMapping("/")
@Slf4j
public class UserController {
//    @Autowired
//    TestAnnotationUtil testAnnotationUtil;
//
//    @RequestMapping("/test")
//    public String test(@Valid UserVo userVo) {
//        testAnnotationUtil.doSomething("working");
//        testAnnotationUtil.testParameter("lincoln");
//        return userVo.toString();
//    }

    @RequestMapping("/exception")
    public String testException(@Valid UserVo userVo) throws CustomException {
        throw new CustomException(99, "未知错误");
    }

    @RequestMapping("/exceptionSys")
    public int testExceptionSys(@Valid UserVo userVo) throws CustomException {
        return 1 / 0;
    }

    @RequestMapping("/map")
    public int testMap(Model model) throws CustomException {
        Map map = model.asMap();
        Map map1 = (HashMap)map.get("md");
        return 1 / 0;
    }

    @RequestMapping("/mapTest")
    public void testMapRemove() throws CustomException {
        Map<String,String> map = new HashMap();
        map.put("1","test");
        map.put("2","test2");
        System.out.println(map.remove("1"));
    }

//    @RequestMapping("/login")
//    public String login() throws CustomException {
//       return "login.jsp";
//    }

    @RequestMapping("/home")
    public String com() throws CustomException {
        return "com.jsp";
    }
}
