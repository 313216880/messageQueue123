/*
 * Company: 
 * Copyright (c) 2012-2032 
 * All Rights Reserved.
 */
package com.cn.messageQueue;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Tdfsdfsdfs {

	public static void main(String[] args) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://www.customs.gov.cn/customs/xwfb34/302425/index.html");
//            httpGet.addHeader("Cookie", "__guid=30183481.4126542558894958000.1576648734948.7078; monitor_count=14; wzws_cid=76581f08faab92ecd38a839f1c8c5d11c5b7a5f401a1e984d1ed4ba8b0257ed94b882de71edc963b43b4b14565b7e2a2b8a41307800a340b967bee2f29424bed9054a2487805fd9238c7bbf3c9d40cda");  
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");  
//            httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");  
//          发起请求
            CloseableHttpResponse response = httpclient.execute(httpGet);
//            实例对象并设置编码格式
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf-8");
//            关闭连接
            response.close();
            httpclient.close();
            Document document = Jsoup.parse(content);
//            System.out.println(document);
//            System.out.println(document.getElementsByTag("li"));
            int i = 0;
            for (Element element : document.getElementsByTag("a")) {
//            	System.out.println(element.getElementsByAttribute("href").isEmpty());
            	if(!element.getElementsByAttribute("title").isEmpty()) {
            		System.out.println(element.attr("href"));
            		System.out.println(element.text());
            		i++;
            		System.out.println(i);
            	}
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
