package com.tempo.challenge.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno
 *
 */
public class RoleMembershipsDTO {

	private String roleId;
	private List<MembershipDTO> membershipList = new ArrayList<>();
	
	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the membershipList
	 */
	public List<MembershipDTO> getMembershipList() {
		return membershipList;
	}
	/**
	 * @param membershipList the membershipList to set
	 */
	public void setMembershipList(List<MembershipDTO> membershipList) {
		this.membershipList = membershipList;
	}
}
