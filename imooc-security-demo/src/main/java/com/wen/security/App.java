package com.wen.security;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wen.security.dto.HttpWenService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("hello world");
		System.out.println(HttpWenService.htmlFiter(HttpWenService.httpRequest("")));
	}
}
