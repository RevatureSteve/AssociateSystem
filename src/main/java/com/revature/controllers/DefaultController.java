package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	@RequestMapping("/")
	public String defaultPage() {
		return "forward:baseLayout.html";
	}
}
