package com.kscapser.rest.api.clientserver;

import com.kscapser.rest.api.clientserver.domain.CustomProfile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ClientServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientServerApplication.class, args);
	}

	@Bean
	@ConfigurationProperties("security.oauth2.client")
	public ClientCredentialsResourceDetails oAuthDetails(){
		return new ClientCredentialsResourceDetails();
	}

	@Bean
	public RestTemplate restTemplate(){
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

		String url = "http://localhost:8080/rest/api/v1/profiles/all";
		CustomProfile result = restTemplate().getForObject(url, CustomProfile.class);
		System.out.println(result);

	}

}
