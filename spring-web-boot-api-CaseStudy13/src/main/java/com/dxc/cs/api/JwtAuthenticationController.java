package com.dxc.cs.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.cs.config.JwtTokenUtil;
import com.dxc.cs.entity.JwtToken;
import com.dxc.cs.entity.UserLogin;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.service.UserLoginServiceImpl;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserLoginServiceImpl userDetailsService;

	@PostMapping("/signin")
	public ResponseEntity<JwtToken> createAuthenticationToken(@RequestBody UserLogin user) throws Exception {
		authenticate(user.getUserName(), user.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtToken(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<UserLogin> saveUser(@RequestBody UserLogin user) throws Exception {

		/*
		 * if(userDetailsService.findById(user.getUserName())) { return new
		 * ResponseEntity<String>("user already exist with this username ",HttpStatus.
		 * BAD_REQUEST); }
		 */
		userDetailsService.save(user);
		return new ResponseEntity<UserLogin>(user, HttpStatus.OK);
	}

	@GetMapping("/user/{userName}")
	public ResponseEntity<UserLogin> findById(@PathVariable("userName") String userName) {
		UserLogin userr = userDetailsService.getById(userName);

		if (userr != null) {
			return new ResponseEntity<UserLogin>(userr, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserLogin>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/forgetpassword")
	public ResponseEntity<UserLogin> updateEmployee(@Valid @RequestBody UserLogin userr, BindingResult result)
			throws EmployeeException {
		ResponseEntity<UserLogin> response = null;

		if (result.hasErrors()) {

			StringBuilder errMsg = new StringBuilder();
			for (FieldError err : result.getFieldErrors()) {
				errMsg.append(err.getDefaultMessage() + ",");
			}
			throw new EmployeeException(errMsg.toString());
		} else {
			userDetailsService.save(userr);
			response = new ResponseEntity<>(userr, HttpStatus.OK);

		}

		return response;
	}

}