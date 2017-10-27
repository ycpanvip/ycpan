package com.wen.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	/**
	 * @author cxhc
	 * @deprecated 暂时还不懂
	 * @param http
	 */
	protected void configure(HttpSecurity http)throws Exception{
		http.formLogin().loginPage("/page/login")
		//http.httpBasic()
		.and().authorizeRequests().anyRequest().authenticated();
	}
	
}
