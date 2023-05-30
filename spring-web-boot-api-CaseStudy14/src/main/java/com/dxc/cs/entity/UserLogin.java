package com.dxc.cs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userLogin")
public class UserLogin implements Serializable
{

	@Id
	@Column(name = "userName")
	@NotBlank(message = "User Name cannot be blank")
	private String userName;
	
	@Transient
	private String password;
	
	@Column(name ="enPassword")
	@JsonIgnore
	private String enPassword;
	
	@Column(name = "role")
	private String role;
	
	
	public UserLogin() {
		//left_unimplemented
	}


	public UserLogin(String userName, String password, String enPassword,String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.enPassword = enPassword;
		this.role=role;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEnPassword() {
		return enPassword;
	}


	public void setEnPassword(String enPassword) {
		this.enPassword = enPassword;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	
	
}
