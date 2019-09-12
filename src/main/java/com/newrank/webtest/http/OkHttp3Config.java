package com.newrank.webtest.http;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @program: webtest
 * @description: OkHttp3配置类
 * @author: ren
 * @create: 2019-09-10 17:30
 **/
@Configuration
public class OkHttp3Config {
    @Bean
    public OkHttpClient okHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // 配置对应相关信息，如超时时间
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        return builder.build();
    }
}
