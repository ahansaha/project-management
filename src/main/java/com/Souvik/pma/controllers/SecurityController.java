package com.Souvik.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Souvik.pma.dao.IUserAccountsRepository;
import com.Souvik.pma.entities.UserAccount;

@Controller
public class SecurityController {
	
	@Autowired
	IUserAccountsRepository userAccountsRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount", userAccount);
		return "security/registration-page";
	}
	
	@PostMapping("/register/save")
	public String saveUser(UserAccount user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userAccountsRepository.save(user);
		return "redirect:/";
	}
}
