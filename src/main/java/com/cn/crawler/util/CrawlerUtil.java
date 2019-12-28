/*
 * Company: 
 * Copyright (c) 2012-2032 
 * All Rights Reserved.
 */
package com.cn.crawler.util;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlerUtil {
	
	private static final String User_Agent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";
	
	
	
	public static  Document getHtmlDocument(String url,String Cookie) {
		return Jsoup.parse(getHtmlContent(url, Cookie));
	}
	
	
	
	public static String getHtmlContent(String url,String Cookie) {
		String content = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        if(null != Cookie && !"".equals(Cookie)) {
        	httpGet.addHeader("Cookie", Cookie);  
        }
        httpGet.addHeader("User-Agent", User_Agent);  
        httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");  
//      发起请求
        CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			//	        实例对象并设置编码格式
	        HttpEntity httpEntity = response.getEntity();
	        content = EntityUtils.toString(httpEntity, "utf-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭连接
			closeStream(response);
			closeStream(httpclient);
		}
		return content;
	}
	
	/**
	 * 关闭流
	 * @param stream
	 */
	private static void closeStream(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (Exception e) {
				// nothing
			}
		}
	}

}
