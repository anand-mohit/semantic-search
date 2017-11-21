package com.stackroute.crawler.service;
/****************************




 ****************************/

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

//Service to retrieve xml page
@Service
public class CrawlerServices {

	public String PageContent(String url) throws  MalformedURLException, IOException {

		Document page = Jsoup.connect(url).get();
		String pageContent = page.toString();
		return (pageContent);
	}
}