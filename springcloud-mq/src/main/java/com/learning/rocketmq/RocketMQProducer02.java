package com.learning.rocketmq;

import com.google.common.collect.Lists;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;

/**
 * 批量发送同步消息
 * @author lifang
 * @since 2021/2/4
 */
public class RocketMQProducer02 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("producer001");
        producer.setNamesrvAddr("192.168.3.23:9876");
        producer.start();

        // topic 消息将要发送的地址
        // body 消息具体内容
        Message message1 = new Message("msg001", "tag-a", "hello rocketmq 第1条消息".getBytes());
        Message message2 = new Message("msg001", "tag-a", "hello rocketmq 第2条消息".getBytes());
        Message message3 = new Message("msg001", "tag-b", "hello rocketmq 第3条消息".getBytes());
        SendResult send = producer.send(Lists.newArrayList(message1, message2, message3));
        System.out.println(send);

        producer.shutdown();
    }
}
