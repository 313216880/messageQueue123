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
 * Description: 生产消息客户端
 * @author LiuHao
 * @date 2019年12月11日上午10:56:37
 * @version 1.0
 */
public class ProduceClient {

	public static void main(String[] args) throws Exception {
		 MqClient.produce("SEND:Hello World");
	}

}
