package com.dxc.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.cs.entity.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, String> {

}
