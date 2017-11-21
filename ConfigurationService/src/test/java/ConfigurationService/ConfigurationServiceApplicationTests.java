/*package ConfigurationService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.config.server.environment.EnvironmentController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConfigurationServiceApplicationTests {

    
   @Autowired
   private EnvironmentController controller;
   
   @LocalServerPort
   private int port;

   @Autowired
   private TestRestTemplate testRestTemplate;
   
   //Check if the controller is not null
   @Test
   public void checkNotNull() {
       assertThat(controller).isNotNull();
   }
   
   //Tests if the config server is allowing access to application.properties file
   @Test
   public void checkIfConfigServerPasses() {
       ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
               "http://localhost:" + this.port + "/application/default", String.class);
       System.out.println(entity.getBody());
       assertEquals(HttpStatus.OK, entity.getStatusCode());
   }
   
   
    * Tests if the config server reports a fail if a client tries
    * to access an unknown properties file 
    
   @Test
   public void checkIfConfigServerFails() {
       ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
               "http://localhost:" + this.port + "/miss", String.class);
       System.out.println(entity.getBody());
       assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
   }
}*/