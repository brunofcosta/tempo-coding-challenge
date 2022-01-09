package com.tempo.challenge.service;

import java.util.List;

import com.tempo.challenge.domain.MembershipRole;
import com.tempo.challenge.domain.MembershipRoleId;
import com.tempo.challenge.domain.Role;

/**
 * @author Bruno
 *
 */
public interface RoleService {
	
	 Role createRole(String roleName);
	
	 MembershipRoleId assignMember(MembershipRoleId member) throws Exception;
	
	 List<MembershipRole> listMembershipRoles(String teamId, String userId);
	
	 List<MembershipRole> listRoleMemberships(String roleId);
	
}
