package com.tempo.challenge.service;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;

/**
 * @author Bruno
 *
 */
public interface RestService {
	
	 boolean isUserValid(String userId) throws RestClientException, URISyntaxException;
	
	 boolean isTeamValid(String teamId) throws RestClientException, URISyntaxException;

	 boolean isUserPartOfTeam(String teamId, String userId) throws RestClientException, URISyntaxException;
}
