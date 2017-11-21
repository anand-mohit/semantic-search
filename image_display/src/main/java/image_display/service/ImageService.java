package image_display.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import image_display.exceptions.ImageNotFoundException;


@Service
public class ImageService {

	String query = "interface";

	public List<String> code(String url) throws MalformedURLException, IOException, ImageNotFoundException {

		Document doc = Jsoup.connect(url).get();
		String s1="";
		String src1="";
		List<String> src2 = new ArrayList<String>();;

		// String preTag = doc.select("img").first().attr("src");

		// String link = "<a href="+preTag+">"+preTag+"</a>";


		Elements elements = doc.getElementsByTag("img");
		// Elements alttext = doc.getElementsByAttribute("alt");
	//	System.out.println(elements.size());
		for (int i = 0; i < elements.size(); i++)

		{
			String alt1 = elements.get(i).attr("alt");
			
			
		      String alt = alt1.toLowerCase();


			if (alt.contains(query)) {
				
			    
			    src1 = elements.get(i).attr("src");
			    System.out.println("src1:- "+ src1);
			    
			    src2.add(src1);
			   }
			
			}
		String link = "<a href="+src1+">"+src1+"</a>";
		// System.out.println("link:-"+ link);
		 System.out.println("list:- "+ src2.get(0));
		 for(int i=0;i<src2.size();i++) {
			 
			 System.out.println("list value:- "+ src2.get(i));
		 }
		 
		return src2;
		
	}

}
