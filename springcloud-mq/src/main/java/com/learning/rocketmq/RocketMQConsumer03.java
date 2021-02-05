package com.learning.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
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
public class RocketMQConsumer03 {

    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("producer003");
        consumer.setNamesrvAddr("192.168.3.23:9876");

        // topic 关注的消息地址
        // subExpression 过滤器
        // consumer.subscribe("msg001", "tag-c");

        // broker需要开启sql功能
        MessageSelector selector = MessageSelector.bySql("age > 90 or age < 10");
        consumer.subscribe("msg001", selector);

        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {

            for (MessageExt messageExt : list) {
                System.out.println("msg : " + new String(messageExt.getBody()));
            }

            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.start();

        System.out.println("consumer 03 start .....");
    }
}
