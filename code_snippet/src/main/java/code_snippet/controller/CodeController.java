package code_snippet.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code_snippet.exceptions.CodeNotFoundException;
import code_snippet.service.CodeService;

@RequestMapping("/code")
@RestController
public class CodeController {

	@Autowired
	CodeService codeService;
	
	@RequestMapping("/snippet")
	public ResponseEntity<?> viewPage() throws MalformedURLException, IOException, CodeNotFoundException {

	//	String url= "view-source:https://creately.com/diagram/example/gybvimc11/Team%20Java%20Class%20Diagram";
		String url= "https://github.com/spring-projects/spring-integration-kafka/issues/139";
		
	//	String url= "https://stackoverflow.com/questions/218384/what-is-a-nullpointerexception-and-how-do-i-fix-it";
	//	String url= "https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=uYQEWvvrBoaW8Qf51aDwDw";
		String code=codeService.code(url);


				return new ResponseEntity<String>(code, HttpStatus.OK);}

	
}
