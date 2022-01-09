package com.tempo.challenge.service.impl;

import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.tempo.challenge.domain.MembershipRole;
import com.tempo.challenge.domain.MembershipRoleId;
import com.tempo.challenge.domain.Role;
import com.tempo.challenge.repository.MembershipRoleRepository;
import com.tempo.challenge.repository.RoleRepository;
import com.tempo.challenge.service.RestService;
import com.tempo.challenge.service.ValidationService;
import com.tempo.challenge.service.exception.ConflictException;
import com.tempo.challenge.service.exception.ObjectNotFoundException;

/**
 * @author Bruno
 *
 */

@Service
public class ValidationServiceImpl implements ValidationService {

	private RoleRepository roleRepository;
	private MembershipRoleRepository membershipRoleRepository;
	private RestService restService;

	public ValidationServiceImpl(RoleRepository roleRepository, MembershipRoleRepository membershipRoleRepository, RestService restService) {
		this.roleRepository = roleRepository;
		this.membershipRoleRepository = membershipRoleRepository;
		this.restService = restService;
	}

	@Override
	public void validation(MembershipRoleId member) throws RestClientException, URISyntaxException{
		checkAssignmentExistance(member);
		checkRoleExistance(member);
		checkUserExistance(member);
		checkTeamExistance(member);
		checkIfTeamContainsUser(member);
		
	}
	
	@Override
	public void checkAssignmentExistance(MembershipRoleId member) {
		Optional<MembershipRole> membershipRole = membershipRoleRepository.findById(member);
		if(membershipRole.isPresent()) {
			throw new ConflictException("This assigment already exists!");
		}
	}
	
	@Override
	public void checkRoleExistance(MembershipRoleId member) {
		Optional<Role> role = roleRepository.findById(member.getRoleId());
		if(!role.isPresent()) {
			throw new ObjectNotFoundException("Object not found! Id: " + member.getRoleId() + ", Type: " + Role.class.getSimpleName());
		}
	}

	@Override
	public void checkUserExistance(MembershipRoleId member) throws RestClientException, URISyntaxException {
		if(!restService.isUserValid(member.getUserId())) {
			throw new ObjectNotFoundException("User not found! Id: " + member.getUserId());
		}
	}

	@Override
	public void checkTeamExistance(MembershipRoleId member) throws RestClientException, URISyntaxException {
		if(!restService.isTeamValid(member.getTeamId())) {
			throw new ObjectNotFoundException("Team not found! Id: " + member.getTeamId());
		}		
	}

	@Override
	public void checkIfTeamContainsUser(MembershipRoleId member) throws RestClientException, URISyntaxException {
		if(!restService.isUserPartOfTeam(member.getTeamId(), member.getUserId())) {
			throw new ObjectNotFoundException("Team not contains the specified user! Id: " + member.getUserId());
		}				
	}

}
