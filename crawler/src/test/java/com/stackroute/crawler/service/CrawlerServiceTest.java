package com.stackroute.crawler.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.never;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.stackroute.crawler.service.CrawlerServices;

import junit.framework.TestCase;

public class CrawlerServiceTest {

	@Spy
	private CrawlerServices crawlerServices;

	//test to check that the correct xml file is being retrieved
	@Test(expected = NullPointerException.class)
	public void shouldVerifyThatXmlPageIsRetrieved() throws MalformedURLException, IOException {

		String url = "https://sourceforge.net/";
		// Act
		String result = crawlerServices.PageContent(url);

		WebClient webclient = new WebClient();
		webclient.getOptions().setJavaScriptEnabled(false);
		HtmlPage page = webclient.getPage(url);
		String pageContent = page.asXml();

		// Assert
		assertThat(result, is(equalTo(pageContent)));

	}

}
