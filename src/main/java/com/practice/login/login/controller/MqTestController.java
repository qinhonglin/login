package com.practice.login.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinhonglin
 * @date 2018/10/23
 */
@RestController
@RequestMapping("/mq")
@Slf4j
public class MqTestController {

    public void sendMq(){
        Message message = new Message();
    }
}
