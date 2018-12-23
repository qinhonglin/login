package com.practice.login.thread.controller;

import com.practice.login.login.dao.AccountUserMapper;
import com.practice.login.login.dao.ConstomerUserMapper;
import com.practice.login.login.entity.AccountUser;
import com.practice.login.login.entity.ConstomerUser;
import com.practice.login.thread.singleton.ThreadPoolDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * @author qinhonglin
 * @date 2018/12/23
 */
@Slf4j
@RestController
@RequestMapping("/thread")
public class ThreadTestController {

    private final static ExecutorService executor = ThreadPoolDemo.getThreadPoolInstance();

    @Autowired
    private ConstomerUserMapper constomerUserMapper;

    @GetMapping("/test")
    public void getIntanceTest(){
        ExecutorService executor3 = ThreadPoolDemo.getThreadPoolInstance();
        ExecutorService executor2 = ThreadPoolDemo.getThreadPoolInstance();
        log.info(executor3.toString());
        log.info(executor2.toString());
        log.info("{}", executor2 == executor3);
    }

    @GetMapping("/dosometh")
    public void doSomeThing() throws ExecutionException, InterruptedException {
        log.info("doSomeThing is start");

        List<FutureTask<Integer>> futureTasks = new ArrayList<>();

        for(int i=0;i<3;i++){
            final int tmpI = i;
            FutureTask<Integer> task = new FutureTask<>(
                 () -> {
                     Thread.sleep(5000);
                     return tmpI;
                 }
            );
            executor.submit(task);
            futureTasks.add(task);
        }

        for(FutureTask task:futureTasks){
            log.info("result is {}",task.get());
        }

    }

    //多个线程不同任务，最后等待所有都完成之后，再一起处理
    @GetMapping("/dosometh2")
    public void doSomeThing2() throws ExecutionException, InterruptedException {
        log.info("doSomeThing is start");

        Integer userId = 4;
        CountDownLatch countDownLatch = new CountDownLatch(2);

        List<FutureTask<Object>> futureTasks = new ArrayList<>();
        futureTasks.add(this.getUserById(userId,countDownLatch));
        FutureTask<Object> numberTask = new FutureTask<>(
                () -> {
                    Thread.sleep(5000);
                    countDownLatch.countDown();
                    return userId;
                }
        );
        futureTasks.add(numberTask);

        for(FutureTask task:futureTasks){
            executor.submit(task);
        }

        ConstomerUser user = (ConstomerUser) futureTasks.get(0).get();
        log.info("await start");
        countDownLatch.await();
        log.info("await end");
        log.info(user.toString());
        log.info(futureTasks.get(1).get().toString());

    }

    //单独的一个任务，这里如何抽象出来呢，写在这有点怪怪的。
    private FutureTask<Object> getUserById(Integer userId,CountDownLatch countDownLatch){
        FutureTask<Object> task = new FutureTask<>(
                () -> constomerUserMapper.selectById(userId)
        );
        countDownLatch.countDown();
        return task;
    }
}
