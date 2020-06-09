package com.example.bams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/adminLoginPage")
	public String adminLoginPage() {
		return "adminLoginPage";
	}
}
