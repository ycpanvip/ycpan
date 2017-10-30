/**
 * 
 */
package com.imooc.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author zhailiang
 *
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http)throws Exception{
		http.formLogin().and().authorizeRequests().anyRequest().authenticated();
		//http.httpBasic() .loginPage("/page/login")
		
	}
}
