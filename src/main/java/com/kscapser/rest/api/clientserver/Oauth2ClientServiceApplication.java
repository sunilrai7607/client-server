package com.kscapser.rest.api.clientserver;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Oauth2ClientServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientServiceApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("security.oauth2.client")
    public ClientCredentialsResourceDetails oAuthDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new OAuth2RestTemplate(oAuthDetails());
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        String url = "http://localhost:9090/api/v1/resources/sayHello";
        String result = restTemplate().getForObject(url, String.class);
        System.out.println(result);

    }

}
