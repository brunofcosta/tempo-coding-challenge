package com.tempo.challenge.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Bruno
 *
 */

@Entity
public class Role implements Serializable {
		
	private static final long serialVersionUID = 4042235366956284994L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String roleId;
	
	@Column(nullable = false, unique = true)
	private String roleName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<MembershipRole> listMembershipRole = new ArrayList<MembershipRole>();

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @param roleName
	 */
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the listMembershipRole
	 */
	public List<MembershipRole> getListMembershipRole() {
		return listMembershipRole;
	}
	/**
	 * @param listMembershipRole the listMembershipRole to set
	 */
	public void setListMembershipRole(List<MembershipRole> listMembershipRole) {
		this.listMembershipRole = listMembershipRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listMembershipRole == null) ? 0 : listMembershipRole.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Role other = (Role) obj;
		if (listMembershipRole == null) {
			if (other.listMembershipRole != null)
				return false;
		} else if (!listMembershipRole.equals(other.listMembershipRole))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", listMembershipRole=" + listMembershipRole + "]";
	}

}
