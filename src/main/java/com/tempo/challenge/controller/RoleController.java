package com.tempo.challenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tempo.challenge.domain.MembershipRoleId;
import com.tempo.challenge.domain.Role;
import com.tempo.challenge.domain.converter.UtilConverter;
import com.tempo.challenge.domain.dto.MembershipRolesDTO;
import com.tempo.challenge.domain.dto.RoleMembershipsDTO;
import com.tempo.challenge.service.RoleService;

/**
 * @author Bruno
 *
 */

@RestController
@RequestMapping("/roles")
public class RoleController {

	private RoleService roleService;

	public RoleController(RoleService roleService){
		this.roleService = roleService;
	}

	@GetMapping("{teamId}/{userId}")
    public ResponseEntity<MembershipRolesDTO> listMembershipRoles(@PathVariable String teamId, @PathVariable String userId) {
    	return ResponseEntity.ok(UtilConverter.toMembershipRolesDTO(roleService.listMembershipRoles(teamId, userId)));
    }
	
	@GetMapping("{roleId}")
    public ResponseEntity<RoleMembershipsDTO> listRoleMemberships(@PathVariable String roleId) {
    	return ResponseEntity.ok(UtilConverter.toRoleMembershipsDTO(roleService.listRoleMemberships(roleId)));
    }
	
	@PostMapping("{roleName}")
    public ResponseEntity<Role> createRole(@PathVariable String roleName) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createRole(roleName));
    }
	
	@PostMapping("/assignMember")
    public ResponseEntity<MembershipRoleId> assignMemberToRole(@RequestBody MembershipRoleId member) throws Exception {
    	return ResponseEntity.status(HttpStatus.CREATED).body(roleService.assignMember(member));
    }

}
