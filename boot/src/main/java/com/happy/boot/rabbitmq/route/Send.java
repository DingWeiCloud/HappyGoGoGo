package com.happy.boot.rabbitmq.route;

import com.happy.boot.rabbitmq.easyQueues.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
    private final  static  String EXCHANAGE_NAME= "测试交换机路由";

    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANAGE_NAME,"direct");
        String message = " 删除商品 ";
        channel.basicPublish(EXCHANAGE_NAME,"delect",null,message.getBytes());
        System.out.println(" 发布 " + message );
        channel.close();
        connection.close();

    }
}
