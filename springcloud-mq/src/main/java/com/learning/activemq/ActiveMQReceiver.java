package com.learning.activemq;

/**
 * @author lifang
 * @since 2021/1/25
 */
public class ActiveMQReceiver {

    public static void main(String[] args)  {

        // //1. 创建工厂
        // ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        //
        // //2. 获取连接
        // Connection connection = activeMQConnectionFactory.createConnection();
        // connection.start();
        //
        // //3. 从连接获取session
        // Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //
        // //4. 创建消息列队
        // Queue queue = session.createQueue("queue_test");
        //
        // //5. 创建消息消费者
        // MessageConsumer consumer = session.createConsumer(queue);
        //
        // while (true){
        //     Message receive = consumer.receive();
        //     if(receive instanceof TextMessage){
        //         System.out.println("message:" + ((TextMessage) receive).getText());
        //     }
        // }
    }
}
