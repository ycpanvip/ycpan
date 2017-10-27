package com.wen.security.controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wen.security.model.TM1CopaParam;
import com.wen.security.util.CxhcUtil;
@RestController 
@RequestMapping("/tm1copa")
public class TM1CopaParamController {
	@PostMapping
	public void TM1CopaParam(@RequestBody TM1CopaParam param) {
		System.out.println(param.toString());
		List<String> list=new ArrayList<String>();
		StringBuffer stringParam=new StringBuffer();
		StringBuffer stringField=new StringBuffer();
		if(StringUtils.isNotBlank(param.getFiscalYear())){
			list.add("fiscalYear");
			stringParam.append(CxhcUtil.getParam("fiscalYear",param.getFiscalYear()));
			stringField.append("fiscalYear");
		}
		if(StringUtils.isNotBlank(param.getPerion())){
			list.add("perion");
			stringParam.append("&&"+CxhcUtil.getParam("perion",param.getPerion()));
			stringField.append("_perion");
		}
		if(StringUtils.isNotBlank(param.getSourceSyetem())){
			list.add("sourceSyetem");
			stringParam.append("&&"+CxhcUtil.getParam("sourceSyetem",param.getSourceSyetem()));
			stringField.append("_sourceSyetem");
		}
		if(StringUtils.isNotBlank(param.getLeUniversal())){
			list.add("leUniversal");
			stringParam.append("&&"+CxhcUtil.getParam("leUniversal",param.getLeUniversal()));
			stringField.append("_leUniversal");
		}
		if(StringUtils.isNotBlank(param.getMrcUniversal())){
			list.add("mrcUniversal");
			stringParam.append("&&"+CxhcUtil.getParam("mrcUniversal",param.getMrcUniversal()));
			stringField.append("_mrcUniversal");
		}
		if(param.getGroupByKey()!=null&&param.getGroupByKey().length>0){
			list.add("groupByKey");
			stringParam.append("&&"+CxhcUtil.getParam("groupByKey",param.getGroupByKey().toString()));
			stringField.append("_groupByKey");
		}
		String[] str=CxhcUtil.listToArray(list);
		System.out.println(CxhcUtil.getStringByArray(str));
		System.out.println(stringParam);
		System.out.println(stringField);
	}	
}
