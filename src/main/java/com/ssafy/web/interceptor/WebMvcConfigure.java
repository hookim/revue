//package com.ssafy.web.interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfigure implements WebMvcConfigurer {
//
//    private final HomeInterceptor handlerHomeInterceptor;
//    private final MemberInterceptor handlerMemberInterceptor;
//
//    public WebMvcConfigure(HomeInterceptor handlerHomeInterceptor, MemberInterceptor handlerMemberInterceptor) {
//        this.handlerHomeInterceptor = handlerHomeInterceptor;
//        this.handlerMemberInterceptor = handlerMemberInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry
//            .addInterceptor(handlerHomeInterceptor)
//            .addPathPatterns("/homes/**");
//
//        registry
//            .addInterceptor(handlerMemberInterceptor)
//            .addPathPatterns("/members/**")
//            .excludePathPatterns("/members/logout");
//    }
//
//}
