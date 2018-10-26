package com.practice.login.login.service;

import com.practice.login.login.dao.AccountUserMapper;
import com.practice.login.login.entity.AccountUser;
import com.practice.login.login.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qinhonglin
 * @date 2018/8/20
 */
@Service
public class AccountUserServiceImpl implements AccountUserService {

    @Autowired
    private AccountUserMapper accountUserMapper;

    @Override
    @Transactional
    public int add(AccountUser accountUser) {
        int res = this.add2(accountUser);
        accountUserMapper.insert(null);
        return res;
    }

    @Override
    @Transactional
    public int add2(AccountUser accountUser){
        accountUserMapper.insert(accountUser);
        return accountUser.getUserId();
    }
}
