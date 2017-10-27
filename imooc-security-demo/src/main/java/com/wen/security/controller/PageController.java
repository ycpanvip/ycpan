package com.wen.security.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class PageController {
	@GetMapping("/login")
	public String loginPage(ModelAndView map) {
		map.getModel().put("hello", "hello world");
		System.out.println("page login");
		return "/login";
	} 
}
