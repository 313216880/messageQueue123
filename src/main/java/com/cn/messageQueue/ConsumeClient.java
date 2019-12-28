/*
 * Company: 
 * Copyright (c) 2012-2032 
 * All Rights Reserved.
 */
package com.cn.messageQueue;

/**
 * 
 * 
 * 
 * Description: 消费消息客户端
 * @author LiuHao
 * @date 2019年12月11日上午10:57:23
 * @version 1.0
 */
public class ConsumeClient {

	public static void main(String[] args) {
        String message = MqClient.consume();
        System.out.println("获取的消息为：" + message);
	}

}
