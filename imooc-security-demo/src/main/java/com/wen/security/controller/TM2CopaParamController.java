package com.wen.security.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wen.security.model.TM1CopaParam;
import com.wen.security.util.BeanResult;
import com.wen.security.util.BeanResultUtil;
import com.wen.security.util.CxhcUtil;
import com.wen.security.util.MyXMLReader2DOM;
@RestController 
@RequestMapping("/tm2copa")
public class TM2CopaParamController {
	@PostMapping
	public void TM1CopaParam(@RequestBody TM1CopaParam param) {
		BeanResult result=new BeanResultUtil().getFieldValueResult(param);
		String stringParam=result.getStringParam() ;
		String stringField=result.getStringField() ;
		System.out.println(result. getOrderByString());//CxhcUtil.getStringByArray(str));
		System.out.println(stringParam);
		System.out.println(stringField);
		MyXMLReader2DOM.StringInXml(result. getOrderByString(), stringField, stringParam, "classpath:test.xml");
	}	
}
