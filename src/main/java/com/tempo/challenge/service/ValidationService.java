package com.tempo.challenge.service;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;

import com.tempo.challenge.domain.MembershipRoleId;

/**
 * @author Bruno
 *
 */
public interface ValidationService {
	
	 void validation(MembershipRoleId member) throws RestClientException, URISyntaxException;
	
	 void checkAssignmentExistance(MembershipRoleId member);
	
	 void checkRoleExistance(MembershipRoleId member);
	
	 void checkUserExistance(MembershipRoleId member) throws RestClientException, URISyntaxException;
	
	 void checkTeamExistance(MembershipRoleId member) throws RestClientException, URISyntaxException;
	
	 void checkIfTeamContainsUser(MembershipRoleId member) throws RestClientException, URISyntaxException;

}
