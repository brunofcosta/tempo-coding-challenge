package com.tempo.challenge.integration;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tempo.challenge.domain.MembershipRole;
import com.tempo.challenge.domain.MembershipRoleId;
import com.tempo.challenge.domain.Role;
import com.tempo.challenge.domain.constant.ApplicationConstants;
import com.tempo.challenge.service.RoleService;

/**
 * @author Bruno
 *
 */

@SpringBootTest
@AutoConfigureMockMvc
public class RestIntegrationTests {
	
	@MockBean
	RoleService roleService;
	
	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void createRoleTest() throws Exception {
		Role request = new Role("Test");
		
		when(roleService.createRole(request.getRoleName())).thenReturn(request);
		
		mockMvc.perform(post("/roles/{roleName}",  request.getRoleName())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.roleName").value(request.getRoleName()));
	}
	
	@Test
	public void assignMemberTest() throws Exception {
		MembershipRoleId id = new MembershipRoleId();
		id.setRoleId("1");
		id.setTeamId(ApplicationConstants.TEAM_TEST_ID);
		id.setUserId(ApplicationConstants.USER_TEST_ID);
		MembershipRole request = new MembershipRole(id);
		
		when(roleService.assignMember(request.getId())).thenReturn(request.getId());
		
		mockMvc.perform(post("/roles/assignMember")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request.getId())))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.userId").value(id.getUserId()));		
	}
	
	@Test
	public void listRoleMembershipsTest() throws Exception {
		String roleId = "1";
		mockMvc.perform(get("/roles/{roleId}", roleId)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.roleId").isEmpty());		
	}
	
	@Test
	public void listMembershipRolesTest() throws Exception {
		mockMvc.perform(get("/roles/{teamId}/{userId}", ApplicationConstants.TEAM_TEST_ID, ApplicationConstants.USER_TEST_ID)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.roleList").isEmpty());		
	}
	
	

}
