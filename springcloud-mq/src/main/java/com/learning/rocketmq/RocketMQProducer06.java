package com.learning.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 事务消息
 *
 * @author lifang
 * @since 2021/2/4
 */
public class RocketMQProducer06 {

    public static void main(String[] args) throws Exception {

        TransactionMQProducer producer = new TransactionMQProducer("producer-transaction-01");
        producer.setNamesrvAddr("192.168.3.23:9876");

        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                System.out.println("----------------------------------------------");
                System.out.println("executeLocalTransaction");
                System.out.printf("topic: %s, msg : %s\n", msg.getTopic(), new String(msg.getBody()));
                System.out.println("transactionId: " + msg.getTransactionId());
                return LocalTransactionState.UNKNOW;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("----------------------------------------------");
                System.out.println("checkLocalTransaction");
                System.out.printf("topic: %s, msg : %s\n", msg.getTopic(), new String(msg.getBody()));
                System.out.println("transactionId: " + msg.getTransactionId());
                return LocalTransactionState.UNKNOW;
            }
        });

        // 异步发送时，重试次数
        // producer.setRetryTimesWhenSendAsyncFailed(2);

        // 同步发送，重试次数
        // producer.setRetryTimesWhenSendFailed(2);

        // 是否向其他broker发送，默认为false
        // producer.setRetryAnotherBrokerWhenNotStoreOK(false);

        producer.start();
        Message message = new Message("msg003", "哈喽，这是一条事务消息！！！".getBytes());
        SendResult send = producer.sendMessageInTransaction(message, "");
        System.out.println(send);
        // producer.shutdown();
    }
}
