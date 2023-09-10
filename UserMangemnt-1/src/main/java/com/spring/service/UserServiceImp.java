package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.UserAccount;
import com.spring.repository.UserRepo;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepo up;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		
		Integer userid = userAcc.getUserid();
		up.save(userAcc);
		if(userid==null) {
			return "Record Saved Successfuly";
		}
		else{
			return "Record upadted";
		}
		
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		
		return up.findAll();
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {
		Optional<UserAccount> findById = up.findById(userId);
		if(findById.isPresent()) {
			return findById.get() ;
		}
		return null;
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {
		boolean exitById=up.existsById(userId);
		if(exitById) {
		  up.deleteById(userId);
		}
		
		return false;
	}
	public void toggleUserActivation(Integer id) {
        UserAccount user = getUserAcc(id);
        if (user != null) {
            // Toggle the active state between "Y" and "N"
            user.setActive_Sw(user.getActive_Sw().equals("Y") ? "N" : "Y");
            up.save(user); // Update the user in the database
        }
    
//	@Override
//	public boolean updateUserAccStatus(Integer userId, String status) {
//		try {
//		up.updateUserAccStatus(userId, status);
//		return true;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return false;
	}
	
}
