//package com.ssafy.web.interceptor;
//
//import ch.qos.logback.core.status.Status;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ssafy.web.global.AccessMemStorage;
//import com.ssafy.web.global.RefreshMemStorage;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class HomeInterceptor implements HandlerInterceptor {
//
//    private final AccessMemStorage accessMemStorage;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    public HomeInterceptor(AccessMemStorage accessMemStorage) {
//        this.accessMemStorage = accessMemStorage;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        response.setContentType("application/json; charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//
//        String tokenCheck = request.getHeader("Authorization");
//        if (tokenCheck == null || !tokenCheck.startsWith("Bearer ")) {
//            Map<String ,String> retMap = new HashMap<>();
//            retMap.put("msg", "토큰을 발급받으세요!???");
//            response.getWriter().write(objectMapper.writeValueAsString(retMap));
//            return false;
//        }
//
//        String requestedToken = tokenCheck.split(" ")[1];
//
//        if(accessMemStorage.getStorage().get(requestedToken) == null ){
//            Map<String ,String> retMap = new HashMap<>();
//            retMap.put("msg", "유효하지 않은 토큰입니다.");
//            response.getWriter().write(objectMapper.writeValueAsString(retMap));
//            return false;
//        }
//
//        if(accessMemStorage.getStorage().get(requestedToken).getExpireDate().before(new Date(System.currentTimeMillis()))){
//            accessMemStorage.getStorage().remove(requestedToken);
//            Map<String ,String> retMap = new HashMap<>();
//            retMap.put("msg", "만료된 토큰");
//            response.getWriter().write(objectMapper.writeValueAsString(retMap));
//            return false;
//        }
//
//        response.setStatus(HttpServletResponse.SC_OK);
//        return true;
//
//
//    }
//}
