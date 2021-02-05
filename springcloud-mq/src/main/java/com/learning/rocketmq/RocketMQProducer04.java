package com.learning.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 单向消息
 * @author lifang
 * @since 2021/2/4
 */
public class RocketMQProducer04 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("producer001");
        producer.setNamesrvAddr("192.168.3.23:9876");
        producer.start();

        // topic 消息将要发送的地址
        // body 消息具体内容
        Message message = new Message("msg001", "hello rocketmq".getBytes());
        producer.sendOneway(message);

        producer.shutdown();
    }
}
