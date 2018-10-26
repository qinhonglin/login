package com.practice.login.login.controller;

import com.alibaba.fastjson.JSON;
import com.practice.login.login.dao.AccountUserMapper;
import com.practice.login.login.entity.AccountUser;
import com.practice.login.login.entity.TestForm;
import com.practice.login.login.vo.InfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author qinhonglin
 * @date 2018/6/21
 */
@RestController
@RequestMapping("/home")
@Slf4j
public class LoginController {
    @Autowired
    private AccountUserMapper accountUserMapper;

    @GetMapping("/users")
    public InfoResponse getUserInfo(){
        InfoResponse<List<AccountUser>> response = new InfoResponse<>();
        List<AccountUser> userList = accountUserMapper.selectAll();
        log.info("size is {}",userList.size());
        response.setData(userList);
        return response;
    }

    /**
     * 登录接口
     * @return
     */
    @GetMapping("/login")
    public InfoResponse login(HttpServletRequest request,AccountUser accountUser){
        InfoResponse infoResponse = new InfoResponse();
        //todo 验证--密码或者微信登录验证？

        //验证成功之后添加session
        HttpSession session = request.getSession();
        session.setAttribute("user",accountUser);
        AccountUser user = (AccountUser) request.getSession().getAttribute("user");
        log.info("user session:{}",JSON.toJSON(user));

        infoResponse.setCode(0);
        infoResponse.setMessage("登录成功");
        return infoResponse;
    }

    @PostMapping("/post_test")
    public InfoResponse test(@RequestBody @Validated TestForm testForm){
        InfoResponse infoResponse = new InfoResponse();
        log.info("{}",JSON.toJSON(testForm));
        return infoResponse;
    }
}
