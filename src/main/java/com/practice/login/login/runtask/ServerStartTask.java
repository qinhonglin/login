package com.practice.login.login.runtask;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author qinhonglin
 * @date 2018/9/10
 */
@Component
@Slf4j
public class ServerStartTask implements CommandLineRunner{

    private final static String GROUP_NAME = "delay_queue";

    @Override
    public void run(String... args) throws Exception {
        log.info("======================123123123=======================");
//        // Instantiate message consumer
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP_NAME);
//        // Subscribe topics
//        consumer.subscribe("TopicTest", "TagA");
//        consumer.setNamesrvAddr("192.168.233.128:9876");
//        // Register message listener
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messages, ConsumeConcurrentlyContext context) {
//                for (MessageExt message : messages) {
//                    // Print approximate delay time period
//                    log.info("Receive message[msgId=" + message.getMsgId() + "] "
//                            + (System.currentTimeMillis() - message.getStoreTimestamp()) + "ms later");
//                }
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });
//        // Launch consumer
//        consumer.start();
    }
}
