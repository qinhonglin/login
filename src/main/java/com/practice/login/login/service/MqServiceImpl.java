package com.practice.login.login.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author qinhonglin
 * @date 2018/10/30
 */
@Service
@Slf4j
public class MqServiceImpl implements MqService {

    private final static String GROUP_NAME = "delay_queue";

    @Override
    public SendResult sendMq(String message) throws MQClientException, RemotingException, InterruptedException, MQBrokerException, UnsupportedEncodingException {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer(GROUP_NAME);
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        //Create a message instance, specifying topic, tag and message body.
        Message msg = new Message("TopicTest",
                "TagA",
                message.getBytes(RemotingHelper.DEFAULT_CHARSET)
        );
        //Call send message to deliver message to one of brokers.
        SendResult sendResult = producer.send(msg);
        log.info("%s%n", sendResult);
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
        return sendResult;
    }
}
