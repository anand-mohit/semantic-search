//package ControllerTest;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.mockito.Spy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//
//import code_snippet.controller.CodeController;
//
//public class TestCodeSnippetController {
//	
//	@Spy
//	CodeController codeController;
//	TestRestTemplate restTemplate = new TestRestTemplate();
//
//	@Test
//	public void testSaveUser() throws Exception {
//		
//		
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<CodeController> entity = new HttpEntity<CodeController>(codeController,
//				headers);
//		ResponseEntity<String> response = restTemplate.exchange(viewPage(), HttpMethod.GET, entity,
//				String.class);
//		assertNotNull(response);
//
//	}
//
//	
//}
