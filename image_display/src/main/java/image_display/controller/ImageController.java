package image_display.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import image_display.exceptions.ImageNotFoundException;
import image_display.service.ImageService;

@RequestMapping("/code")
@RestController
public class ImageController {

	@Autowired
	ImageService imageService;

	@RequestMapping("/javaimage")
	public ResponseEntity<List<String>> viewpage() throws MalformedURLException, IOException, ImageNotFoundException {



		String url = "https://www.javatpoint.com/interface-in-java";

		
		List<String> code = imageService.code(url);
		//System.out.println("code is: " +code);

	
		return new ResponseEntity<List<String>>(code,HttpStatus.OK);
	}

}
