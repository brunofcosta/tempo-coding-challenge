package com.tempo.challenge.integration;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.tempo.challenge.domain.constant.ApplicationConstants;

/**
 * @author Bruno
 *
 */

@SpringBootTest
@AutoConfigureMockMvc
public class ExternalRestIntegrationTests {
	
	@Mock
	RestTemplate restTemplate;
	
	@Test
	public void listAllUsersAPI() throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();     

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

	    ResponseEntity<String> response = restTemplate.exchange(new URI(ApplicationConstants.USER_API_URL), HttpMethod.GET, entity, String.class);

	    Assert.isTrue(response.getStatusCode() == HttpStatus.OK, "");
	    
	    Assert.isTrue(!response.getBody().equals("null"), "");
	}
	
	@Test
	public void listUserAPI() throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();     

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

	    ResponseEntity<String> response = restTemplate.exchange(new URI(ApplicationConstants.USER_API_URL + ApplicationConstants.USER_TEST_ID), HttpMethod.GET, entity, String.class);

	    Assert.isTrue(response.getStatusCode() == HttpStatus.OK, "");
	    
	    Assert.isTrue(!response.getBody().equals("null"), "");
	}
	
	@Test
	public void listAllTeamsAPI() throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();     

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

	    ResponseEntity<String> response = restTemplate.exchange(new URI(ApplicationConstants.TEAM_API_URL), HttpMethod.GET, entity, String.class);

	    Assert.isTrue(response.getStatusCode() == HttpStatus.OK, "");
	    
	    Assert.isTrue(!response.getBody().equals("null"), "");
	}
	
	@Test
	public void listTeamAPI() throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();     

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

	    ResponseEntity<String> response = restTemplate.exchange(new URI(ApplicationConstants.TEAM_API_URL + ApplicationConstants.TEAM_TEST_ID), HttpMethod.GET, entity, String.class);

	    Assert.isTrue(response.getStatusCode() == HttpStatus.OK, "");
	    
	    Assert.isTrue(!response.getBody().equals("null"), "");
	}

}
