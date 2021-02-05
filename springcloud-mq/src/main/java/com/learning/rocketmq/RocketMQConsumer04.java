package com.learning.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 消费消息
 * @author lifang
 * @since 2021/2/4
 */
public class RocketMQConsumer04 {

    public static void main(String[] args) throws Exception {

        // run("producer005-1", "msg005");
        // run("producer005-2", "msg005");
        // run("producer005-3", "msg001");
        // run("producer005-4", "msg001");
        // run("producer005-5", "msg001");
        run("producer005-6", "msg001");

        while (true){
            System.out.println("------------------------------------------- " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private static void run(String group, String topic){
        new Thread(() -> {
            try {
                start1(group, topic);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void start1(String group, String topic) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(group);
        consumer.setNamesrvAddr("192.168.3.23:9876");

        // topic 关注的消息地址
        // subExpression 过滤器
        consumer.subscribe(topic, "*");

        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            for (MessageExt messageExt : list) {
                System.out.println("topic:" + topic + " msg : " + new String(messageExt.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.start();

        System.out.println("consumer 05 start .....");
    }
}
