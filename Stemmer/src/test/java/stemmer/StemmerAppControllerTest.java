/*package stemmer;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.stemmer.StemmerApp;
import com.example.stemmer.controller.StemmerAppController;
import com.example.stemmer.domain.StemmedQuery;
import com.example.stemmer.service.StemmerAppService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StemmerApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StemmerAppControllerTest {
    String user1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    StemmerAppService stemmerAppService;
    StemmedQuery stemmedQuery;
    
    @Autowired
    StemmerAppController controller;
    
    @Before
    public void setUp() throws Exception {
         stemmedQuery = new StemmedQuery("configur starter sleep breath");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + "/stem"+ uri;
    }
    @After
    public void tearDown() throws Exception {
    	stemmedQuery = null;
    }    
    
//  Check if the controller has initialized or not
    @Test
    public void controllerInitialized() {
    	assertThat(controller).isNotNull();
    }
    
//  Checks if the output obtained is correct.
    @Test
    public void testIfOutputIsCorrect() throws Exception {
        HttpEntity<StemmedQuery> entity = new HttpEntity<StemmedQuery>(stemmedQuery, headers);
        ResponseEntity<StemmedQuery> response = restTemplate.exchange(
                createURLWithPort(""),
                HttpMethod.GET, entity, StemmedQuery.class);
        assertNotNull(response);
        StemmedQuery actual = response.getBody();
        assertEquals(stemmedQuery.getStemmerQuery(),actual.getStemmerQuery());
    }
    
//  Checks if the output obtained is incorrect
    @Test
    public void testIfOutputIsIncorrect() throws Exception {
        HttpEntity<StemmedQuery> entity = new HttpEntity<StemmedQuery>(stemmedQuery, headers);
        ResponseEntity<StemmedQuery> response = restTemplate.exchange(
                createURLWithPort(""),
                HttpMethod.GET, entity, StemmedQuery.class);
        assertNotNull(response);
        StemmedQuery actual = response.getBody();
        assertNotEquals("Incorrect Response",actual.getStemmerQuery());
    }
}*/