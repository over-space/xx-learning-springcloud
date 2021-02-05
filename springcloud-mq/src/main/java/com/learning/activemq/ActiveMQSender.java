package com.learning.activemq;

/**
 * @author lifang
 * @since 2021/1/25
 */
public class ActiveMQSender {

    public static void main(String[] args) throws InterruptedException {

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
        // //5. 创建消息提供者
        // MessageProducer producer = session.createProducer(queue);
        // for (int i = 0; i < 100; i++) {
        //     TextMessage message = session.createTextMessage("hello ActiveMQ" + i);
        //     // 通过消息提供者发送消息到ActiveMQ
        //     Thread.sleep(1000);
        //     producer.send(message);
        // }
        //
        // connection.close();
        // System.out.println("exit");
    }

}
