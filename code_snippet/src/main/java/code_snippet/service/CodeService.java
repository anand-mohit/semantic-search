package code_snippet.service;

import java.io.IOException;
import java.net.MalformedURLException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
//import org.apache.commons.lang.StringUtils;

import code_snippet.exceptions.CodeNotFoundException;

@Service
public class CodeService {

	public String code(String url) throws  MalformedURLException, IOException, CodeNotFoundException {

//		String code= "<code>";
		Document doc = Jsoup.connect(url).get();
	
		Elements preTag = doc.select("pre");
		Element htmlTag= doc.select("html").first();
	//	Element preTag = doc.select("pre").first();
	//	Element[] pretags;
//		for(int i=0; i<StringUtils.countMatches(s1, "<pre>"); i++) {
//			Element pretags= doc.select("pre").first();
//			String str= pretags.toString();
			
		//	pretags[i]= preTag.first();
		//	s2[i]= pretags[i].toString();
		//}
		
		String[] keywords= {"=", "{", "}", ";"};
		if(preTag.toString()==null) {
			System.out.println("No code present in the website");
			throw new CodeNotFoundException("No code present in the website");
		}
		else {
			
			String s1= preTag.toString();
			String s2= htmlTag.toString();
			for(int i =0; i<keywords.length; i++) {
			if(s1.contains(keywords[i])) {
//			if (StringUtils.contains(preTag.toString(), code)) {
//				String s11= preTag.toString();
//				for(int i=0; i<StringUtils.countMatches(s11, "<pre>"); i++)
				//s2[i]= s1.split("<pre>");
		//		//for(int i=0; i<s2.length; i++)
		//		System.out.println(s2.toString());
		//		return s2;
			String[] lines= s1.split("\r\n|\r|\n");
			float length= lines.length;
			System.out.println("number of lines of code in the url is= "+length);
			String[] lines2= s2.split("\r\n|\r|\n");
			float length2= lines2.length;
			System.out.println("total number of lines in the document is= "+length2);
			float percentCode= (float)((length/length2)*100);
			System.out.println("Percentage of code present in the url is= "+percentCode);
				return s1;
		//	}
			}
			}
			}
		return null;
}
}

