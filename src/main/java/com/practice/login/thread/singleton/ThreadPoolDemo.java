package com.practice.login.thread.singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.*;

/**
 * @author qinhonglin
 * @date 2018/12/23
 */
@Slf4j
public class ThreadPoolDemo {


    //这里value注解不起作用，原因是直接使用静态方法是不能让类初始化的，所以这里注解就取不到值了
//    @Value("${singleton.corePoolSize}")
    private final static int CORE_POOL_SIZE = 3;

    private ThreadPoolDemo(){}

    private static class SingletonThreadPool{

        private static ExecutorService executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                CORE_POOL_SIZE,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
    }

    public static ExecutorService getThreadPoolInstance(){
        return SingletonThreadPool.executor;
    }
}
