package com.stackroute.Parser.Services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ch.qos.logback.core.boolex.Matcher;

public class ParserServices {
	int queryscore = 0;
	int metaqueryscore = 0;
	int metaidf = 1;
	int queryidf = 2;
	int titleidf = 3;
	int h1idf=6;
	int h2idf=5;
	int h3idf=4;
	int h4idf=3;
	int h5idf= 2;
	int h6idf=1;
	int pidf=1;

	Map<String, Integer> queryresult = new HashMap<String, Integer>();
	Map<String, Integer> metaquery = new HashMap<String, Integer>();

	public Map<String, Integer> QueryResult(String pageContent, String[] query) {
		// Elements lis;
		int querycount;
		String tes = null;
		// List<String> queryresult = new ArrayList <String>();
		for (String temp : query) {
			Elements lis = Jsoup.parse(pageContent).getElementsContainingOwnText(temp);
			Elements ele = Jsoup.parse(pageContent).getAllElements();
			// System.out.println(lis);
			tes = ele.text().toLowerCase();
			// System.out.println(tes);

			querycount = StringUtils.countMatches(tes, temp);
			// System.out.println(querycount);
			queryresult.put(temp, querycount);

			// System.out.println(queryresult);
		}

		for (Map.Entry<String, Integer> entry : queryresult.entrySet()) {

			queryscore += (entry.getValue() * queryidf);

		}
//		System.out.println(queryscore);

		return queryresult;
	}

	public Map<String, Integer> MetaKeywords(String url, String[] query) throws IOException {
		int querycount = 0;

		String Metakeywords = Jsoup.parse(url).getElementsByTag("meta").attr("content");
		// System.out.println("Meta Keywords"+keywords);

		for (String temp : query) {
			querycount = StringUtils.countMatches(Metakeywords, temp);
			// System.out.println(temp+" "+querycount);

			metaquery.put(temp, querycount);

		}

		for (Map.Entry<String, Integer> entry : metaquery.entrySet()) {

			metaqueryscore += (entry.getValue() * metaidf);

		}

//		System.out.println(metaqueryscore);

		return metaquery;

	}

	public int titleScore(String url, String[] query) throws IOException {
		Document doc = Jsoup.connect(url).get();
		String title = doc.title().toLowerCase();
		System.out.println(title);

		int titlescore = 0;

		for (String temp : query) {
			titlescore += (StringUtils.countMatches(title, temp) * titleidf);
		}
//		System.out.println(titlescore);
		return titlescore;

	}

	public int h1Score(String url, String[] query) throws IOException {
//		System.out.println("h1");
		Document doc = Jsoup.connect(url).get();
		String docs = doc.toString();
		String regex = "<h1.*>(.*)?</h1>";

		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(docs);
		if (matcher.find() == false) {
			// System.out.println(matcher.group(1).toLowerCase());
			return 0;
		}

		// System.out.println(title);
		else {
			int h1score = 0;
			for (String temp : query) {
				h1score += (StringUtils.countMatches(matcher.group().toLowerCase(), temp) * h1idf);
			}
//			System.out.println(h1score);
			return h1score;
		}
	}

	public int h2Score(String url, String[] query) throws IOException {
//		System.out.println("h2");
		Document doc = Jsoup.connect(url).get();
		String docs = doc.toString();
		String regex = "<h2.*>(.*)?</h2>";

		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(docs);
		if (matcher.find() == false) {
			return 0;
			// System.out.println(matcher.group(1).toLowerCase());
		}

		// System.out.println(title);

		int h2score = 0;
		for (String temp : query) {
			h2score += (StringUtils.countMatches(matcher.group().toLowerCase(), temp) * h2idf);
		}
//		System.out.println(h2score);
		return h2score;

	}

	public int h3Score(String url, String[] query) throws IOException {
//		System.out.println("h3");
		Document doc = Jsoup.connect(url).get();
		String docs = doc.toString();
		String regex = "<h3.*>(.*)?</h3>";

		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(docs);
		if (matcher.find() == false) {
			return 0;
			// System.out.println(matcher.group(1).toLowerCase());
		}

		// System.out.println(title);

		int h3score = 0;
		for (String temp : query) {
			h3score += (StringUtils.countMatches(matcher.group().toLowerCase(), temp) * h3idf);
		}
//		System.out.println(h3score);
		return h3score;

	}

	public int h4Score(String url, String[] query) throws IOException {
//		System.out.println("h4");
		Document doc = Jsoup.connect(url).get();
		String docs = doc.toString();
		String regex = "<h4.*>(.*)?</h4>";

		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(docs);
		if (matcher.find() == false) {
			return 0;
			// System.out.println(matcher.group(1).toLowerCase());
		}

		// System.out.println(title);

		int h4score = 0;
		for (String temp : query) {
			h4score += (StringUtils.countMatches(matcher.group().toLowerCase(), temp) * h4idf);
		}
//		System.out.println(h4score);
		return h4score;

	}

	public int h5Score(String url, String[] query) throws IOException {
		
//		System.out.println("h5");
		Document doc = Jsoup.connect(url).get();
		String docs = doc.toString();
		String regex = "<h5.*>(.*)?</h5>";

		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(docs);
		if (matcher.find() == false) {
			return 0;
			// System.out.println(matcher.group(1).toLowerCase());
		}

		// System.out.println(title);

		int h5score = 0;
		for (String temp : query) {
			h5score += (StringUtils.countMatches(matcher.group().toLowerCase(), temp) * h5idf);
		}
//		System.out.println(h5score);
		return h5score;

	}

	public int h6Score(String url, String[] query) throws IOException {
//		System.out.println("h6");
		Document doc = Jsoup.connect(url).get();
		String docs = doc.toString();
		String regex = "<h6.*>(.*)?</h6>";

		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(docs);
		if (matcher.find() == false) {
			return 0;
			// System.out.println(matcher.group(1).toLowerCase());
		}

		// System.out.println(title);

		int h6score = 0;
		for (String temp : query) {
			h6score += (StringUtils.countMatches(matcher.group().toLowerCase(), temp) * h6idf);
		}
//		System.out.println(h6score);
		return h6score;

	}

	 public int pScore(String url, String[]query) throws IOException {
	 Document doc = Jsoup.connect(url).get();

	 Elements paragraphs = doc.select("p");

	
	 int pscore=0;
	 for(String temp:query) {
	 pscore+= (StringUtils.countMatches(paragraphs.text().toLowerCase(),
	 temp)*pidf);
	 }
//	 System.out.println(pscore);
	 return pscore;
	
	 }

	public int score() {

		int score = metaqueryscore;

//		System.out.println(score);

		return score;
	}

}
