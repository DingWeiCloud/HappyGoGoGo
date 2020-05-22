package com.happy.boot.rabbitmq.easyQueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class GetMes {
    private final static String QUENE_NAME = "q_test_01";

    public static void main(String[] args) throws  Exception{
        //创建连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUENE_NAME,false,false,false,null);
        //定义队列的消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        // 让这个队列的消费者去监听这个队列
        channel.basicConsume(QUENE_NAME,false,queueingConsumer);
        //获取消息
        while (true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String s = new String(delivery.getBody());
            System.out.println(" 消费者  " + s);
        }
    }
}
