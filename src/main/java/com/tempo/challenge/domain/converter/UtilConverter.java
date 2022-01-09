package com.tempo.challenge.domain.converter;

import java.util.List;

import com.tempo.challenge.domain.MembershipRole;
import com.tempo.challenge.domain.dto.MembershipDTO;
import com.tempo.challenge.domain.dto.MembershipRolesDTO;
import com.tempo.challenge.domain.dto.RoleMembershipsDTO;

/**
 * @author Bruno
 *
 */
public abstract class UtilConverter {

	private UtilConverter() {
	}

	public static MembershipRolesDTO toMembershipRolesDTO(List<MembershipRole> list) {
		MembershipRolesDTO result = new MembershipRolesDTO();
		for(MembershipRole element : list) {
			if(result.getMemberShip() == null) {
				MembershipDTO membershipDTO = new MembershipDTO(element.getId().getTeamId(), element.getId().getUserId());
				result.setMemberShip(membershipDTO);
			}
			result.getRoleList().add(element.getId().getRoleId());
		}
		return result;
	}
	
	public static RoleMembershipsDTO toRoleMembershipsDTO(List<MembershipRole> list) {
		RoleMembershipsDTO result = new RoleMembershipsDTO();
		for(MembershipRole element : list) {

			if(result.getRoleId() == null) {
				result.setRoleId(element.getId().getRoleId());
			}
			MembershipDTO membershipDTO = new MembershipDTO(element.getId().getTeamId(), element.getId().getUserId());
			result.getMembershipList().add(membershipDTO);
		}

		return result;
	}

}
