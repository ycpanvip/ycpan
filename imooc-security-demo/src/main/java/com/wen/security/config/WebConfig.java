package com.wen.security.config;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.wen.security.filter.TimeFilter;
import com.wen.security.interceptor.TimeInterceptor;
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Resource 
	private TimeInterceptor timeInterceptor;
	public void addInterceptors(InterceptorRegistry registry) {
		//InterceptorRegistration ir=registry.addInterceptor(timeInterceptor);
		//ir.addPathPatterns("/user/*");
	}
	//@Bean 
	public FilterRegistrationBean TimeFilter() {
		FilterRegistrationBean filterRegistrationBean =new FilterRegistrationBean();
		TimeFilter timeFilter=new TimeFilter();
		filterRegistrationBean.setFilter(timeFilter);
		List<String> urls=new ArrayList<String>();
		urls.add("/user/*"); 
		filterRegistrationBean.setUrlPatterns(urls);
		return filterRegistrationBean;
	}
	//异步支持
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setDefaultTimeout(5000);
		super.configureAsyncSupport(configurer);
	}
}
