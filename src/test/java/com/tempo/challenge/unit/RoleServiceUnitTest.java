package com.tempo.challenge.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.tempo.challenge.domain.MembershipRoleId;
import com.tempo.challenge.domain.constant.ApplicationConstants;
import com.tempo.challenge.service.impl.RoleServiceImpl;

/**
 * @author Bruno
 *
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleServiceUnitTest {
	
	@Autowired
	@InjectMocks
	private RoleServiceImpl roleService;
	
	@Test
	public void createRoleSuccessful() {
		Assert.notNull(roleService.createRole("TestRole"), "");
	}
	
	@Test
	public void createRoleFail() {
		Assert.notNull(roleService.createRole(null), "");
	}
	
	@Test
	public void assignMemberSuccess() throws Exception {
		MembershipRoleId member = new MembershipRoleId();
		member.setRoleId("1");
		member.setTeamId(ApplicationConstants.TEAM_TEST_ID);
		member.setUserId(ApplicationConstants.USER_TEST_ID);
		Assert.notNull(roleService.assignMember(member), "");
	}
	
	@Test
	public void assignMemberFail() throws Exception {
		MembershipRoleId member = new MembershipRoleId();
		member.setRoleId("1");
		member.setTeamId("2");
		member.setUserId("2");
		Assert.notNull(roleService.assignMember(member), "");
	}
	
	@Test
	public void listMembershipRolesSuccess() throws Exception {
		Assert.notEmpty(roleService.listMembershipRoles(ApplicationConstants.TEAM_TEST_ID, ApplicationConstants.USER_TEST_ID), "");
	}
	
	@Test
	public void listMembershipRolesFail() throws Exception {
		Assert.notEmpty(roleService.listMembershipRoles("2", "2"), "");
	}
	
	@Test
	public void listRoleMembershipsSuccess() throws Exception {
		Assert.notEmpty(roleService.listRoleMemberships("1"), "");
	}
	
	@Test
	public void listRoleMembershipsFail() throws Exception {
		Assert.notEmpty(roleService.listRoleMemberships("4"), "");
	}

}
