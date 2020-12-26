package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.StateMaster;
import com.example.entity.UserMaster;
import com.example.service.UserService;

@Controller
public class UserMasterRegistrationController {

	@Autowired
	private UserService service;

	@GetMapping("/LoadUserRegistration")
	public String showRegistrationPage(Model model) {
		model.addAttribute("registrationPage", new UserMaster());
		return "UserRegistration";
	}

	@PostMapping("/saveUser")
	public String saveUserRegistration(Model model, @ModelAttribute("userRegistration") UserMaster userRegistration) {
		String msg = null;
		if (userRegistration.getId() == null) {
			msg = "UserRegistration sucessfully";
		} else {
			msg = "UserRegistration updated sucessfully";
		}

		boolean IsSaved = service.saveUser(userRegistration);
		if (IsSaved) {
			model.addAttribute("sucessMsg", "UserRegistrationSucessfully");
		} else {
			model.addAttribute("erroMsg", "UserRegistrationFailed");
		}
		return "UserRegistration";
	}
	
	@GetMapping("/countryId")
	public String findByCountry() {
		return "Country";
	}
	@GetMapping("/cityId")
	public String findByCityId() {
		return"Country";
	}
	@GetMapping("/stateId")
	public String findByStateId() {
		return "Country";
	}
	

	@GetMapping("/userLogin")
	public String userLoginPage() {
		return "UserLogin";
	}

	@GetMapping("/unlockAccount")
	public String Unlockaccount() {
		return "UserLogin";
	}

	@GetMapping("/forgetPassword")
	public String forgetPassword() {
		return "UserLogin";
	}
	@GetMapping("/tempPwd")
	public String userTempPassword() {
		return "UserLogin";
	}
	@GetMapping("/emailValid")
	public String UserEmailvalidation() {
		return "UserLogin";
	}

}
