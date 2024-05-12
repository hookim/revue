package com.ssafy.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.web.global.AccessMemStorage;
import com.ssafy.web.global.RefreshMemStorage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemberInterceptor implements HandlerInterceptor {

    private final AccessMemStorage accessMemStorage;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public MemberInterceptor(AccessMemStorage accessMemStorage, RefreshMemStorage refreshMemStorage) {
        this.accessMemStorage = accessMemStorage;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        String tokenCheck = request.getHeader("Authorization");
        if (tokenCheck == null || !tokenCheck.startsWith("Bearer ")) {
            return true;
        }

        String requestedToken = tokenCheck.split(" ")[1];

        if(accessMemStorage.getStorage().get(requestedToken) == null ){
            return true;
        }

        if(accessMemStorage.getStorage().get(requestedToken).getExpireDate().before(new Date(System.currentTimeMillis()))){
            accessMemStorage.getStorage().remove(requestedToken);
            return true;
        }

        Map<String, String> retMap = new HashMap<>();
        retMap.put("msg", "로그인 상태");
        response.getWriter().write(objectMapper.writeValueAsString(retMap));
        return false;

    }
}
