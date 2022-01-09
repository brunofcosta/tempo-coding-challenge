package com.tempo.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tempo.challenge.domain.MembershipRole;
import com.tempo.challenge.domain.MembershipRoleId;

/**
 * @author Bruno
 *
 */
public interface MembershipRoleRepository extends JpaRepository<MembershipRole, MembershipRoleId> {
	
	List<MembershipRole> findByIdTeamIdAndIdUserId(String teamId, String userId);
	
	List<MembershipRole> findByIdRoleId(String roleId);

}
