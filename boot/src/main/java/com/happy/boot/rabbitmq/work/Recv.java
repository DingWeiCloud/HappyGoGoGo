package com.happy.boot.rabbitmq.work;

import com.happy.boot.rabbitmq.easyQueues.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {
    private final static String QUEST_NAME = "TASK_QUEUE_WORK";
    public static void main(String[] args) throws Exception {
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEST_NAME,false,false,false,null);
        // 同一时刻服务器只会发送一条信息给消费者
        // channel.basicQos(1);
        // 定义队列的消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        // 监听队列 .手动返回完成状态   false 手动 true 自动
        channel.basicConsume(QUEST_NAME, true, queueingConsumer);
        while (true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [y] Received '" + message + "'");
            // 休眠
            Thread.sleep(10);
            // 返回确认状态，注释掉表示使用自动确认模式
            // channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
