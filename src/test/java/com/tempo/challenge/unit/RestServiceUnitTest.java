package com.tempo.challenge.unit;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;

import com.tempo.challenge.domain.constant.ApplicationConstants;
import com.tempo.challenge.service.impl.RestServiceImpl;

/**
 * @author Bruno
 *
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestServiceUnitTest {
	
	@InjectMocks
	private RestServiceImpl restService;
	
	@Test
	public void isUserValidSuccess() throws RestClientException, URISyntaxException{
		Assert.isTrue(true == restService.isUserValid(ApplicationConstants.USER_TEST_ID), "");
	}
	
	@Test
	public void isUserValidFail() throws RestClientException, URISyntaxException{
		Assert.isTrue(true == restService.isUserValid("1"), "");
	}
	
	@Test
	public void isTeamValidSuccess() throws RestClientException, URISyntaxException{
		Assert.isTrue(true == restService.isTeamValid(ApplicationConstants.TEAM_TEST_ID), "");
	}
	
	@Test
	public void isTeamValidFail() throws RestClientException, URISyntaxException{
		Assert.isTrue(true == restService.isTeamValid("1"), "");
	}
	
	@Test
	public void isUserPartOfTeamSuccess() throws RestClientException, URISyntaxException{
		Assert.isTrue(true == restService.isUserPartOfTeam(ApplicationConstants.TEAM_TEST_ID, ApplicationConstants.USER_TEST_ID), "");
	}
	
	@Test
	public void isUserPartOfTeamFail() throws RestClientException, URISyntaxException{
		Assert.isTrue(true == restService.isUserPartOfTeam(ApplicationConstants.TEAM_TEST_ID, "abcd-123"), "");
	}
	
	
}
