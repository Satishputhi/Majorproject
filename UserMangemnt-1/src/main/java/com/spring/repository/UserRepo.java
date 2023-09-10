package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.UserAccount;

@Repository
public interface UserRepo extends JpaRepository<UserAccount,Integer> {
	@Modifying
	@Transactional
	@Query("update UserAccount set Active_Sw=:status where userId=:userId")
	public boolean updateUserAccStatus(Integer userId, String status);

}
