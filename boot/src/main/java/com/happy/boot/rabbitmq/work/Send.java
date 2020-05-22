package com.happy.boot.rabbitmq.work;

import com.happy.boot.rabbitmq.easyQueues.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
    private final  static String QUEST_NAME = "TASK_QUEUE_WORK";

    public static void main(String[] args) throws Exception{
        //创建连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEST_NAME,false,false,false,null);
        for (int i = 0; i < 100; i++) {
            String message = "" + i;
            channel.basicPublish("",QUEST_NAME,null,message.getBytes());
            System.out.println("[x] send '"+ message +"'");
            Thread.sleep(1000);
        }
        channel.close();
        connection.close();
    }

}
