package ro.ubb.lab7Spring.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
