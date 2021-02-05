package com.learning.rocketmq;

import com.google.common.collect.Lists;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * 延迟消息
 *
 * @author lifang
 * @since 2021/2/4
 */
public class RocketMQProducer08 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("producer005-1");
        producer.setNamesrvAddr("192.168.3.23:9876");
        producer.start();

        // topic 消息将要发送的地址
        // body 消息具体内容
        Message message1 = new Message("msg001", "hello rocketmq".getBytes());
        message1.setDelayTimeLevel(3);

        SendResult send = producer.send(message1);

        producer.shutdown();
        System.out.println(send);
    }
}
