package com.tempo.challenge.service.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.tempo.challenge.domain.constant.ApplicationConstants;
import com.tempo.challenge.service.RestService;

/**
 * @author Bruno
 *
 */

@Service
public class RestServiceImpl implements RestService {
	
	@Override
	public boolean isUserValid(String userId) throws RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();     

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

	    ResponseEntity<String> response = restTemplate.exchange(new URI(ApplicationConstants.USER_API_URL + userId), HttpMethod.GET, entity, String.class);

		if(response != null && response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null && !response.getBody().equals("null")){
			return true;
		}

	    return false;
	}
	
	@Override
	public boolean isTeamValid(String teamId) throws RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();     

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

	    ResponseEntity<String> response = restTemplate.exchange(new URI(ApplicationConstants.TEAM_API_URL + teamId), HttpMethod.GET, entity, String.class);
	    
	    if(response != null && response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null && !response.getBody().equals("null")) {
	    	return true;
	    } 
		
		return false;
	}

	@Override
	public boolean isUserPartOfTeam(String teamId, String userId) throws RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();     

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

	    ResponseEntity<String> response = restTemplate.exchange(new URI(ApplicationConstants.TEAM_API_URL + teamId), HttpMethod.GET, entity, String.class);
	    
	    if(response != null && response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null && response.getBody().contains(userId)) {
	    	return true;
	    } 
	    
	    return false;
	}

}
