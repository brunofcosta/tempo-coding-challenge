package com.tempo.challenge.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tempo.challenge.domain.MembershipRole;
import com.tempo.challenge.domain.MembershipRoleId;
import com.tempo.challenge.domain.Role;
import com.tempo.challenge.repository.MembershipRoleRepository;
import com.tempo.challenge.repository.RoleRepository;
import com.tempo.challenge.service.RoleService;
import com.tempo.challenge.service.ValidationService;

/**
 * @author Bruno
 *
 */

@Service
public class RoleServiceImpl implements RoleService {
	

	private RoleRepository roleRepository;
	private MembershipRoleRepository membershipRoleRepository;
	private ValidationService validationService;

	public RoleServiceImpl(RoleRepository roleRepository, MembershipRoleRepository membershipRoleRepository, ValidationService validationService) {
		this.roleRepository = roleRepository;
		this.membershipRoleRepository = membershipRoleRepository;
		this.validationService = validationService;
	}

	@Override
	public Role createRole(String roleName) {
		return roleRepository.save(new Role(roleName.trim()));
	}

	@Override
	public MembershipRoleId assignMember(MembershipRoleId member) throws Exception {
		validationService.validation(member);
		return membershipRoleRepository.save(new MembershipRole(member)).getId();			
	}

	@Override
	public List<MembershipRole> listMembershipRoles(String teamId, String userId) {
		return membershipRoleRepository.findByIdTeamIdAndIdUserId(teamId, userId);
	}

	@Override
	public List<MembershipRole> listRoleMemberships(String roleId) {
		return membershipRoleRepository.findByIdRoleId(roleId);
	}

	
	

}
