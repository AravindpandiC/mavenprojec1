package com.example.springlearning.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class RateLimitHandlerInterceptor implements HandlerInterceptor {

    static final Map<String,Integer> requestCounts = new ConcurrentHashMap<>();

    static final String START_TIME="startTime";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        if(requestCounts.containsKey(ip) && requestCounts.get(ip)>10){
            System.out.println("Too many requests from IP: " + ip);
        //    return false;
        }
        request.setAttribute(START_TIME, System.currentTimeMillis());
        requestCounts.compute(ip, (key, count) -> count == null ? 1 : count + 1);
        System.out.println(requestCounts);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        System.out.println("Request processing time: " + (endTime - (long)request.getAttribute(START_TIME)) + " ms");
    }

}
