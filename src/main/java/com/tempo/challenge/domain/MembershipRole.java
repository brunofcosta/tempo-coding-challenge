package com.tempo.challenge.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author Bruno
 *
 */

@Entity
public class MembershipRole implements Serializable {
	
	private static final long serialVersionUID = -7082768211612543924L;

	@EmbeddedId
	private MembershipRoleId id;
	
	@MapsId("roleId")
	@ManyToOne
	private Role role;

	public MembershipRole() {
		super();
	}

	/**
	 * @param id
	 */
	public MembershipRole(MembershipRoleId id) {
		super();
		this.id = id;
		Role role = new Role();
		role.setRoleId(id.getRoleId());
		this.setRole(role);
	}

	/**
	 * @return the id
	 */
	public MembershipRoleId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(MembershipRoleId id) {
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MembershipRole other = (MembershipRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MembershipRole [id=" + id + ", role=" + role + "]";
	}
	

}
