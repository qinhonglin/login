package com.practice.login.login.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qinhonglin
 * @date 2018/6/25
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer url = request.getRequestURL();
        log.info("url is {}",url);

        String  user = (String) request.getSession().getAttribute("user");
        if(user == null){
//            request.getSession().setAttribute("user","testUser");
            response.setStatus(200);
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print("该用户没有登录");
            return false;
        }
        return true;
    }
}
