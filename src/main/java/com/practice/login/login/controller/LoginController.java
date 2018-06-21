package com.practice.login.login.controller;

import com.practice.login.login.dao.AccountUserMapper;
import com.practice.login.login.entity.AccountUser;
import com.practice.login.login.vo.InfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qinhonglin
 * @date 2018/6/21
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AccountUserMapper accountUserMapper;

    @GetMapping("")
    public InfoResponse getUserInfo(){
        InfoResponse<List<AccountUser>> response = new InfoResponse<>();
        List<AccountUser> userList = accountUserMapper.selectAll();
        response.setData(userList);
        return response;
    }
}
