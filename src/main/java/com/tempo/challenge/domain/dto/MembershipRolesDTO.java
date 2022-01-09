package com.tempo.challenge.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno
 *
 */
public class MembershipRolesDTO {
	
	private MembershipDTO memberShip;
	private List<String> roleList = new ArrayList<>();
	
	/**
	 * @return the memberShip
	 */
	public MembershipDTO getMemberShip() {
		return memberShip;
	}
	/**
	 * @param memberShip the memberShip to set
	 */
	public void setMemberShip(MembershipDTO memberShip) {
		this.memberShip = memberShip;
	}
	/**
	 * @return the roleList
	 */
	public List<String> getRoleList() {
		return roleList;
	}
	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

}
