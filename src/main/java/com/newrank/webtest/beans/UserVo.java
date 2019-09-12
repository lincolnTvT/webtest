package com.newrank.webtest.beans;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: webtest
 * @description: user实体类
 * @author: ren
 * @create: 2019-06-18 13:56
 **/
@Data
public class UserVo {
    @NotNull(message = "名称不能为空")
    String name;
    @NotNull(message = "密码不能为空")
    String password;
}
