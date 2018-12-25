package com.practice.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qinhonglin
 * @date 2018/12/25
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize;

    @Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize;

    @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity;

    private String threadNamePrefix = "AsyncExecutorThread-";

    @Bean(name = "asyncExecutor")
    public ExecutorService asyncExecutor() {
        ExecutorService executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity)
        );
        return executor;
    }
}
