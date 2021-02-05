package com.learning.rocketmq;

import com.google.common.collect.Lists;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

/**
 * 异步发送消息
 * @author lifang
 * @since 2021/2/4
 */
public class RocketMQProducer03 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("producer001");
        producer.setNamesrvAddr("192.168.3.23:9876");
        producer.start();

        // topic 消息将要发送的地址
        // body 消息具体内容
        Message message1 = new Message("msg001", "hello world!!!".getBytes());

        producer.send(message1, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功！");
            }

            @Override
            public void onException(Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("消息发送异常！");
            }
        });

        // TimeUnit.SECONDS.sleep(5);
        System.out.println("producer exit");
    }
}
