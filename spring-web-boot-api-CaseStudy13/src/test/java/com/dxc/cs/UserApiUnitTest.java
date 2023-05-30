package com.dxc.cs;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dxc.cs.entity.UserLogin;
import com.dxc.cs.service.UserLoginServiceImpl;

@AutoConfigureMockMvc
@SpringJUnitConfig
@WebMvcTest(UserLogin.class)
public class UserApiUnitTest {

	@Autowired
	private MockMvc mvcClient;

	@MockBean
	private UserLoginServiceImpl loginServiceImpl;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	private List<UserLogin> testData;

	private static final String API_URL_SIGNIN = "/signin";
	private static final String API_URL_SIGNUP = "/signup";

	@Test
	public void existentUserCanGetTokenAndAuthentication() throws Exception {
		String userName = "pratikk";
		String password = "12345";

		String body = "{\"username\":\"" + userName + "\", \"password\":\"" + password + "\"}";

		MvcResult result = mvcClient.perform(MockMvcRequestBuilders.post("/v2/token").content(body))
				.andExpect(status().isOk()).andReturn();

		String response = result.getResponse().getContentAsString();
		response = response.replace("{\"access_token\": \"", "");
		String token = response.replace("\"}", "");

		mvcClient.perform(MockMvcRequestBuilders.get("/test").header("Authorization", "Bearer " + token))
				.andExpect(status().isOk());
	}

}
