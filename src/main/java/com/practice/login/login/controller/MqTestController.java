package com.practice.login.login.controller;

import com.practice.login.login.service.MqService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinhonglin
 * @date 2018/10/23
 */
@RestController
@RequestMapping("/mq")
@Slf4j
public class MqTestController {

    @Autowired
    private MqService mqService;

    @GetMapping("/test")
    public void sendMq() {
        Message message = new Message();
        try {
            mqService.sendMq("qinhonglin123333");
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/add")
    public void addtest() {
        ArrayList<Integer> test = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            if (i >= 10) {
                log.info("123");
            }
            test.add(1);
        }
        log.info(test.toString());
    }

    @GetMapping("/hash")
    public void hashtest() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1);
    }

    @GetMapping("/why/{nub}")
    public void hashTest2(@PathVariable Integer nub) {
        for (int i = 0; i < 100; i++) {
            log.info("i<<5 - i = {} , i * " + nub + " = {}", (i << 5) - i, i * nub);
        }
    }

}
