package com.happy.boot.rabbitmq.subscription;

import com.happy.boot.rabbitmq.easyQueues.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class Recv2 {
    private  final  static String EXCHANAGE_NAME = "订阅模式 交换机";
    private final static String QUEUE_NAME = "订阅 消费者队列 B";

    public static void main(String[] args) throws Exception{
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //将队列和交换机绑定
        channel.queueBind(QUEUE_NAME,EXCHANAGE_NAME,"");
        // 服务器每次只能发送一个
        channel.basicQos(1);
        // 创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        // 消费者监听队列
        channel.basicConsume(QUEUE_NAME,false,queueingConsumer);
        while (true){
            // 监听队列中的信息
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            // 获取信息
            byte[] body = delivery.getBody();
            String s = new String(body);
            System.out.println(" 消费者B " + s );
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }


    }
}
