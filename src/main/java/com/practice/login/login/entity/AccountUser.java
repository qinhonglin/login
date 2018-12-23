package com.practice.login.login.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

@Data
@Slf4j
public class AccountUser implements Serializable {

    private Integer userId;

    private String userName;

    private String mobile;

    private Byte status;

    private Integer createUser;

    private Date createTime;

    private TestForm testForm;

    private static final long serialVersionUID = 1L;

    public static Integer STATICINTEGER = 1;

    public AccountUser(){
        log.info("AccountUser init");
    }

}