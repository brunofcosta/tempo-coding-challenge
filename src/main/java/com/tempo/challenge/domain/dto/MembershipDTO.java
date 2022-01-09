package com.tempo.challenge.domain.dto;

/**
 * @author Bruno
 *
 */
public class MembershipDTO {
	
	private String teamId;
	private String userId;

	public MembershipDTO() {
		super();
	}
	/**
	 * @param teamId
	 * @param userId
	 */
	public MembershipDTO(String teamId, String userId) {
		super();
		this.teamId = teamId;
		this.userId = userId;
	}
	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
