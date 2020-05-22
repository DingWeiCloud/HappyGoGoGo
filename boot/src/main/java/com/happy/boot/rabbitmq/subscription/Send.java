package com.happy.boot.rabbitmq.subscription;

import com.happy.boot.rabbitmq.easyQueues.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
    private  final  static String EXCHANAGE_NAME = "订阅模式 交换机";

    public static void main(String[] args) throws Exception{
        // 创建连接
        Connection connection = ConnectionUtil.getConnection();
        // 创建mq通道
        Channel channel = connection.createChannel();
        // 声明网关
        channel.exchangeDeclare(EXCHANAGE_NAME,"fanout");
        String message = "hello 订阅模式";
        channel.basicPublish(EXCHANAGE_NAME,"",null,message.getBytes());
        System.out.println("  发送消息  " + message);
        channel.close();
        connection.close();
    }
}
