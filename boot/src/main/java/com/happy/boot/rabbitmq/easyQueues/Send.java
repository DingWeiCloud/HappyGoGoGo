package com.happy.boot.rabbitmq.easyQueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
    private final static String QUENE_NAME = "q_test_01";

    public static void main(String[] args) throws Exception{
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //声明创建队列
        channel.queueDeclare(QUENE_NAME,false,false,false,null);
        String message ="hello world 3 ";
        channel.basicPublish("",QUENE_NAME,null,message.getBytes());
        System.err.println(" [x] send '" + message + "' ");
        //关闭通道 关闭连接
        channel.close();
        connection.close();

    }
}
