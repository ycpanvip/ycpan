package com.wen.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wen.security.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@GetMapping
	public  List<User> hello(@RequestParam(value="username",required=true,defaultValue="cxhc") String name) {
		System.out.println(name);
		List<User> list=new ArrayList<User>();
		list.add(new  User());
		list.add(new  User());
		list.add(new  User());
		return list;
	}
}
