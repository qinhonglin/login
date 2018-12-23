package com.practice.login.login.dao;

import com.practice.login.login.entity.ConstomerUser;

public interface ConstomerUserMapper {
    int insert(ConstomerUser record);

    int insertSelective(ConstomerUser record);

    ConstomerUser selectById(Integer id);
}