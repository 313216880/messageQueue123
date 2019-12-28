/*
 * Company: 
 * Copyright (c) 2012-2032 
 * All Rights Reserved.
 */
package com.cn.crawler.function;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.cn.crawler.util.CrawlerUtil;

/**
 * 
 * 中国海关
 * 
 * Description: 
 * @author LiuHao
 * @date 2019年12月18日下午5:03:30
 * @version 1.0
 */
public class Customs {
	
	public static void main(String[] args) {
//		tgrabodayCustoms();
//		wangYi();
		gongGaoXinxi();
	}
	
	/**
	 * 
	 *http://www.pbc.gov.cn/rmyh/105208/index.html
	 * Title: gongGaoXinxi
	 * Description:
	 */
	public static void gongGaoXinxi() {
		Document document = CrawlerUtil.getHtmlDocument("http://www.pbc.gov.cn/rmyh/105208/index.html", "__guid=30183481.4126542558894958000.1576648734948.7078; wzws_cid=1ef12576161902f8be87de077f230114a5fc50cb0f8cd9e2b90d9478b24df565f51751615852b1792b3223baf86b1b8decf0344315b0850fdc8c5eaeee0b5e37a30b1154304997161af1f935253b9eeb; monitor_count=31");
		System.out.println(document);
	}
	
	/**
	 * http://www.gov.cn/guowuyuan/wangyi/index.htm
	 *
	 * Title: name
	 * Description:
	 */
	public static void wangYi() {
		Document document = CrawlerUtil.getHtmlDocument("http://www.gov.cn/guowuyuan/wangyi/index.htm", null);
		int i = 0;
		for (Element element : document.getElementsByTag("a")) {
        	if(!element.getElementsByAttribute("title").isEmpty()) {
        		System.out.println(element.attr("href"));
        		System.out.println(element.text());
        		i++;
        		System.out.println(i);
        	}
		}
	}

	/**
	 * 今日海关
	 * http://www.customs.gov.cn/customs/xwfb34/302425/index.html
	 * Title: tgrabodayCustoms
	 * Description:
	 */
	public static void tgrabodayCustoms() {
		Document document = CrawlerUtil.getHtmlDocument("http://www.customs.gov.cn/customs/xwfb34/302425/index.html", null);
		int i = 0;
		for (Element element : document.getElementsByTag("a")) {
        	if(!element.getElementsByAttribute("title").isEmpty()) {
        		System.out.println(element.attr("href"));
        		System.out.println(element.text());
        		i++;
        		System.out.println(i);
        	}
		}
	}
	
	
}
