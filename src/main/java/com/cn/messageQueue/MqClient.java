/*
 * Company: 
 * Copyright (c) 2012-2032 
 * All Rights Reserved.
 */
package com.cn.messageQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 
 * 
 * 
 * Description: 访问消息队列的客户端
 * @author LiuHao
 * @date 2019年12月11日上午10:50:03
 * @version 1.0
 */
public class MqClient {

	// 生产消息
	public static void produce(String message) throws Exception {
		// 本地的的BrokerServer.SERVICE_PORT 创建SOCKET
		Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println(message);
		out.flush();
		socket.close();
	}

	// 消费消息
	public static String consume(){
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        String message = null;
		try {
			socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
			in = new BufferedReader(new InputStreamReader(
			        socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			//先向消息队列发送命令
	        out.println("CONSUME");
	        out.flush();
	      //再从消息队列获取一条消息
	        message = in.readLine();
	        
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return message;
    }
}
