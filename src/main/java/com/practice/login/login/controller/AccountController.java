package com.practice.login.login.controller;

import com.practice.login.login.entity.AccountUser;
import com.practice.login.login.form.AccountUserForm;
import com.practice.login.login.service.AccountUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinhonglin
 * @date 2018/8/20
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountUserService accountUserService;

    @PostMapping("/account")
    public int addAccount(@RequestBody AccountUserForm accountUserForm){
        AccountUser accountUser = new AccountUser();
        BeanUtils.copyProperties(accountUserForm,accountUser);
        Integer res = accountUserService.add(accountUser);
        return res;
    }

}
