package com.newrank.webtest.http;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @program: webtest
 * @description: okHttp3Controller测试类
 * @author: ren
 * @create: 2019-09-10 17:34
 **/
@RestController
@RequestMapping(value = "/httpClient")
public class OkHttp3Controller {
    // 引入okHttp3
    @Autowired
    private OkHttpClient okHttpClient;
    @RequestMapping(value = "test")
    public String test() throws IOException {
        Gson gson = new Gson();
        // 声明url
//        String url = "http://api.xunmang.com/api/ad/appmsg/publisher/list/?limit=#SIZE&offset=#PAGE&official_account_id=164701&sort_by=0";
        String url = "http://api.xunmang.com/api/ad/appmsg/detail/?ad_id=151057";
        // 声明request对象
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cookie","user=118029:1i782r:Yu8rqQw4UcYYM9W22D9ZPvsWlq8;csrftoken=ZopklrSYTDpP7SQ4TjlCJxxGzw8JXtxBcQpLpOteirKs42GfLNHYkcut0CcnwTZU;sessionid=1z471gwudn33s6nx9rm7e536r00df63g;user=118029:1i8Eyr:9sILYv9Es7yyYUQ4xhBTaoSJSl8;csrftoken=xTuHTaIQcCbDmfN6fhExCqo0QBA8V8KAr6ZORWphg4x5q4R3IBMwtRN65Hjmm23P;sessionid=654qtbhinwcehx9oalh8m38dv3d51m9f")
                .get()
                .build();
        // 进行get请求
        Call call = okHttpClient.newCall(request);
        // 同步
        Response response = call.execute();
        if (response.isSuccessful()) {
            ResponseBody responseBody = response.body();
            String responseStr = responseBody.string();
            JsonObject orgin = new JsonParser().parse(responseStr).getAsJsonObject();
            JsonElement jsonObject = orgin.get("data");
            System.out.println(responseStr);
            return responseStr;
        }
       return "fail";
    }
}
