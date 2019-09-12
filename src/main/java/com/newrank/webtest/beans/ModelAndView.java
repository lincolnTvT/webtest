package com.newrank.webtest.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: webtest
 * @description: 返回前台实体类
 * @author: ren
 * @create: 2019-06-21 14:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelAndView<T> {
    private T value;
    public boolean success;
}
