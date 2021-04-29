package com.ty.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 注册一个安全拦截器，拦截所有请求（登录接口及 knife4j 的UI界面接口除外）
    String[] knife4jPaths = new String[]{
            "/doc.html",
            "/webjars/**",
            "/swagger-resources/**",
            "/swagger-ui.html/**",
            "/v2/api-docs",
            "/favicon.ico",
            "/error"
    };

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new MyStringToNumberConverterFactory());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())//添加拦截器
                .addPathPatterns("/**")//拦截路径
                .excludePathPatterns(knife4jPaths);//放行路径
    }

}
