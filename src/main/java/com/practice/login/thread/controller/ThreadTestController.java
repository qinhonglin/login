package com.practice.login.thread.controller;

import com.practice.login.thread.singleton.ThreadPoolDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

/**
 * @author qinhonglin
 * @date 2018/12/23
 */
@Slf4j
@RestController
@RequestMapping("/thread")
public class ThreadTestController {

    @GetMapping("/test")
    public void getIntanceTest(){
        ExecutorService executor = ThreadPoolDemo.getThreadPoolInstance();
        ExecutorService executor2 = ThreadPoolDemo.getThreadPoolInstance();
        log.info(executor.toString());
        log.info(executor2.toString());
        log.info("{}", executor2 == executor);
    }
}
