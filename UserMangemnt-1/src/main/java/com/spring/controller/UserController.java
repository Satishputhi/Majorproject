package com.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.UserAccount;
import com.spring.service.UserServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {
	
	@Autowired
	private UserServiceImp uI;
	
	@GetMapping("/")
	 public String index(Model model) {
		 model.addAttribute("user", new UserAccount());
		return "index";
		 
	 }
@PostMapping("/save-user")
public String handleSubmitBtn(@ModelAttribute("user") UserAccount userAcc, Model model) {
	
	
	String msg= uI.saveOrUpdateUserAcc(userAcc);
	model.addAttribute("msg", msg);
	model.addAttribute("user", new UserAccount());
	return "index";
	
}
@GetMapping("/user")
public String viewUsers(Model model) {
	List<UserAccount> list = uI.getAllUserAccounts();
	model.addAttribute("users", list);
	return "view-user";
	}
//@GetMapping("/edit/{userid}")
//public String editUser(@PathVariable Integer userId, Model model) {
//	   uI.getUserAcc(userId);
//	   return "index";
//	 
// }
@GetMapping("/edit")
public String editUserForm(@RequestParam("id") Integer userId, Model model) {
  UserAccount userAcc = uI.getUserAcc(userId);
 model.addAttribute("user", userAcc);
    return "index";
}

//@PostMapping("/edit/{userid}")
//public String editUser(@ModelAttribute("user") UserAccount userAcc, Model model) {
//    uI.saveOrUpdateUserAcc(userAcc);
//    return "redirect:/user/";
//}

@GetMapping("/delete")
public String deleteUser(@RequestParam("id") Integer userId,Model model) {
    uI.deleteUserAcc(userId);
    model.addAttribute("msg","User Deleted Successfully");
    return "forward:/user";
}
//@PostMapping("/toggleActivation")
//public String toggleActivation(Integer userId) {
//    uI.toggleUserActivation(userId);
//    return "redirect:/user/";
//}
//
// public String deleteUser(Integer userId, Model model) {
//	return "list";
//	 
// }
//
@GetMapping("/update")
public String changeAccStatus(@RequestParam("id") Integer userId,@RequestParam("status") String status,Model model) {
	uI.updateUserAccStatus(userId, status);
	if("Y".equals(status)) {
		model.addAttribute("msg","User Activated Successfully");
	}else {
		model.addAttribute("msg","User De-Activated Successfully");
	}
	
	return "forward:/user";

}
}
