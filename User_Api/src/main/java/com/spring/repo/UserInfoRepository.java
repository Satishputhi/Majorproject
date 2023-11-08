package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Integer>{

	public UserInfoEntity findByEmail(String email);

	

}
