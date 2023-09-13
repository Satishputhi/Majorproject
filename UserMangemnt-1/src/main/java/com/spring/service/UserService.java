package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.entity.UserAccount;

public interface UserService {
	public String saveOrUpdateUserAcc(UserAccount userAcc);

	 public List<UserAccount> getAllUserAccounts( );

	 public UserAccount getUserAcc(Integer userId);

	 public boolean deleteUserAcc(Integer userId);

	 public boolean updateUserAccStatus(Integer userId, String status);
}
