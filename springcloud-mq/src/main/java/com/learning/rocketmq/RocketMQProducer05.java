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
 * 批量发送同步消息
 * @author lifang
 * @since 2021/2/4
 */
public class RocketMQProducer05 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("producer001");
        producer.setNamesrvAddr("192.168.3.23:9876");
        producer.start();

        // topic 消息将要发送的地址
        // body 消息具体内容
        List<Message> messages = Lists.newArrayListWithCapacity(100);
        for (int i = 1; i <= 100; i++) {
            Message message = new Message("msg001", "tag-c", String.format("hello rocketmq 第%d条消息", i).getBytes());
            message.putUserProperty("age", String.valueOf(i));
            messages.add(message);
        }
        SendResult send = producer.send(messages);
        System.out.println(send);
        producer.shutdown();
    }
}
