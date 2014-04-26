package org.alice.account.web.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/spring-hsqldb.xml",
		"file:src/main/webapp/WEB-INF/spring/spring-security.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-account-web.xml" })
public class LoginLogoutControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testLoginPageAccess() throws Exception {
		this.mockMvc.perform(get("/login")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/login.jsp"));
	}
	
	@Test
	public void testChangePassword() throws Exception {
		this.mockMvc.perform(get("/account/changePassword")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/changePassword.jsp"));
	}
}
