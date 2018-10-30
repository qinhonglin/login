package com.practice.login.login.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author qinhonglin
 * @date 2018/10/23
 */
public interface MqService {
   SendResult sendMq(String msg) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException;
}
