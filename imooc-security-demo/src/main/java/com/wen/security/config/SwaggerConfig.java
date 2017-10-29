package com.wen.security.config;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //必须存在
@EnableSwagger2 //必须存在
public class SwaggerConfig{
    @Bean
    public Docket demoApi() {
    	   return new Docket(DocumentationType.SWAGGER_2)
    			   .apiInfo(getApiInfo()).select()
    		       .apis(RequestHandlerSelectors.basePackage("com.wen.security.controller"))
    		       .paths(PathSelectors.any())
    		       .build();
    }

    protected ApiInfo getApiInfo()
    {
      return new ApiInfo("Rest Web Service", "cxhc Rest Web Service " + new Date(), "", "",
          new Contact("cxhc", "", ""), "", "",new ArrayList<VendorExtension>());
    }
}