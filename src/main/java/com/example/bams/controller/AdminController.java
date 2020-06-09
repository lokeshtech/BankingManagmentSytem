package com.example.bams.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bams.model.User;
import com.example.bams.repository.UserDAO;
import com.example.bams.service.EmailService;
import com.example.bams.service.SMSService;
import com.example.bams.service.UserService;
import com.example.bams.uttils.BAMSUtiils;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SMSService smsService;
	
	@RequestMapping("/approve")
	public ModelAndView approvalUser(@RequestParam("id") int id) throws MessagingException, IOException {
		int custid=BAMSUtiils.generateCustomerID();
		ModelAndView modelAndView = new ModelAndView();
		User user=userService.findUserById(id);
		int updateindicateid=userService.updateCustomerId(id, custid);
		if(updateindicateid!=0) {
			emailService.approvalSendEmail(user, custid);
			smsService.sendApproveSMS(user, custid);
			modelAndView.addObject("adminMessage", "User approval for the user "+user.getName() + user.getLastName() + " "+ "is Approved by Admin");
		}
		else {
			modelAndView.addObject("adminMessage", "User approval for the user "+user.getName() + user.getLastName() + " " + "is not Approved by Admin");
		}
		
		List<User> userList=userService.getAllUsers();
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	
	@RequestMapping("/reject")
	public ModelAndView RejectUser(@RequestParam("id") int id) throws MessagingException, IOException  {
		ModelAndView modelAndView = new ModelAndView();
		User user=userService.findUserById(id);
		int updateindicateid=userService.updateCustomerId(id, 0);
		if(updateindicateid!=0) {
			emailService.rejectSendEmail(user);
			smsService.sendRejectSMS(user, 0);
			modelAndView.addObject("adminMessage", "User approval for the user "+user.getName() + user.getLastName() + " "+ "is Rejected by Admin");
		}
		else {
			modelAndView.addObject("adminMessage", "User approval for the user "+user.getName() + user.getLastName() + " " + "is not Approved by Admin");
		}
		
		List<User> userList=userService.getAllUsers();
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	

}
