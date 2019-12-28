/*
 * Company: 
 * Copyright (c) 2012-2032 
 * All Rights Reserved.
 */
package com.cn.messageQueue;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PcTestsd {

	public static void main(String[] args) {
		try {
	        Document document = Jsoup.connect("http://www.csrc.gov.cn/pub/newsite/zjhxwfb/xwdd/").get();
//	        String title = document.select(".linkto").text();
//	        System.out.println(title);
//	        System.out.println(document.getAllElements());
	        Elements elements = document.getAllElements();
	        for (Element element : elements) {
	        	System.out.println("==========");
	        	if(element != null) {
	        		System.out.println(element.select("a"));
	        	}
			}
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
