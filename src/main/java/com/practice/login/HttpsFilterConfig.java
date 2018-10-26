package com.practice.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 本来是想用来转https的
 * 但是这个过滤发生在https之后，所以并没有用
 * 额，好像确实有用
 * @author qinhonglin
 * @date 2018/7/3
 */
//@Configuration
//@WebFilter
public class HttpsFilterConfig extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURL = request.getRequestURL().toString();
        String protocol = requestURL.split("://")[0];
        if ("http".equals(protocol)) {
            requestURL = requestURL.replace("http", "https");
            response.sendRedirect(requestURL);
        }
        filterChain.doFilter(request, response);
    }
}
