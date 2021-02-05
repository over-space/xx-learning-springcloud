package com.learning.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * 消费消息
 * @author lifang
 * @since 2021/2/4
 */
public class RocketMQConsumer01 {

    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("producer001");
        consumer.setNamesrvAddr("192.168.3.23:9876");

        // topic 关注的消息地址
        // subExpression 过滤器
        consumer.subscribe("msg001", "tag-a");

        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {

            for (MessageExt messageExt : list) {
                System.out.println("msg : " + new String(messageExt.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.start();


        System.out.println("consumer 01 start .....");
    }
}
