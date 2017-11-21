package ConfigurationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*Different Annotations to allow the application to function as 
 * spring boot application, as config server and to connect it 
 * to the discovery service
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
//@EnableZuulProxy
public class ConfigurationServiceApplication {


	public static void main(String[] args) {
		 
		SpringApplication.run(ConfigurationServiceApplication.class, args);

	}

}
