package com.example.bams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.bams.model.Address;
import com.example.bams.model.Role;
import com.example.bams.model.User;
import com.example.bams.model.UserModel;
import com.example.bams.service.UserService;
import com.example.bams.uttils.BAMSUtiils;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/login")
	public ModelAndView loginpage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping(value = "/registration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		UserModel userModel = new UserModel();
		modelAndView.addObject("userModel", userModel);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@PostMapping(value = "/registration")
	public ModelAndView createNewUser(@Valid UserModel userModel, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (userModel.getName().isEmpty() || userModel.getName().equals("")) {
			bindingResult.rejectValue("name", "error.userModel", "Please Enter Name for User Registration");
		}
		if (userModel.getLastName().isEmpty() || userModel.getLastName().equals("")) {
			bindingResult.rejectValue("lastName", "error.userModel", "Please Enter Last Name for User Registration");
		}
		if (userModel.getEmail().isEmpty() || userModel.getEmail().equals("")) {
			bindingResult.rejectValue("email", "error.userModel", "Please Enter Email for User Registration");
		}
		if (userModel.getUserName().isEmpty() || userModel.getUserName().equals("")) {
			bindingResult.rejectValue("userName", "error.userModel", "Please Enter UserName for User Registration");
		}
		if (userModel.getPassword().isEmpty() || userModel.getPassword().equals("")) {
			bindingResult.rejectValue("password", "error.userModel", "Please Enter Password for User Registration");
		}
		if (userModel.getRole().isEmpty() || userModel.getRole().equals("") || userModel.getRole().equals("0")) {
			bindingResult.rejectValue("role", "error.userModel", "Please Select Role for User Registration");
		}
		User userExists = userService.findUserByUserName(userModel.getUserName());
		if (userExists != null) {
			bindingResult.rejectValue("userName", "error.userModel",
					"There is already a user registered with the user name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			User user = new User();
			user.setName(userModel.getName());
			user.setLastName(userModel.getLastName());
			user.setEmail(userModel.getEmail());
			user.setPhonenumber(userModel.getPhonenumber());
			user.setGender(userModel.getGender());
			user.setPancard(userModel.getPancard());
			user.setDob(userModel.getDob());
			//user.setCustid(BAMSUtiils.generateCustomerID());
			user.setUserName(userModel.getUserName());
			user.setPassword(userModel.getPassword());
			Address adr = new Address();
			adr.setStreet(userModel.getStreet());
			adr.setCity(userModel.getCity());
			adr.setPincode(userModel.getPincode());
			adr.setState(userModel.getState());
			adr.setCountry(userModel.getCountry());
			adr.setAtype(userModel.getAtype());
			adr.setUid(user);
			Address padr = new Address();
			if (userModel.getAtype().equals("CURRENT")) {
				padr.setStreet(userModel.getPstreet());
				padr.setCity(userModel.getPcity());
				padr.setPincode(userModel.getPpincode());
				padr.setState(userModel.getPstate());
				padr.setCountry(userModel.getPcountry());
				padr.setAtype("PERMANENT");
				padr.setUid(user);
			}
			userService.saveUser(user, adr, padr, userModel.getRole());
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("userModel", new UserModel());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@GetMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " "
				+ user.getLastName() + " (" + user.getEmail() + ")");
		Set<Role> role = user.getRoles();
		for (Role r : role) {
			if (r.getRole().equals("ADMIN")) {
				List<User> userList=userService.getAllUsers();
				//System.out.println(userList.size());
				modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
				modelAndView.addObject("userList", userList);
				modelAndView.setViewName("admin/home");
			} else {
				if (r.getRole().equals("EMPLOYEE")) {
					modelAndView.addObject("employeeMessage", "Content Available Only for Users with Employee Role");
					modelAndView.setViewName("employee/home");
				} else {
					if (r.getRole().equals("CUSTOMER")) {
						modelAndView.addObject("customerMessage",
								"Content Available Only for Users with Customer Role");
						modelAndView.setViewName("customer/home");
					}
				}
			}
		}

		return modelAndView;
	}
}
