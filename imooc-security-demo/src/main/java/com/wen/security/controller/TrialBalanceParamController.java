package com.wen.security.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wen.security.model.TrialBalanceParam;
import com.wen.security.util.CxhcUtil;
@RestController 
@RequestMapping("/trialbalance")
public class TrialBalanceParamController {
	@PostMapping
	public void TM1CopaParam(@RequestBody TrialBalanceParam param) {
		System.out.println(param.toString());
		List<String> list=new ArrayList<String>();
		StringBuffer stringParam=new StringBuffer();
		StringBuffer stringField=new StringBuffer();
		if(StringUtils.isNotBlank(param.getUniversalLedger())){
			list.add("universalLedger");
			stringParam.append(CxhcUtil.getParam("universalLedger",param.getUniversalLedger()));
			stringField.append("universalLedger");
		}
		if(StringUtils.isNotBlank(param.getUserId())){
			list.add("userId");
			stringParam.append("&&"+CxhcUtil.getParam("userId",param.getUserId()));
			stringField.append("_userId");
		}
		if(StringUtils.isNotBlank(param.getLeUniversal())){
			list.add("leUniversal");
			stringParam.append("&&"+CxhcUtil.getParam("leUniversal",param.getLeUniversal()));
			stringField.append("_leUniversal");
		}
		if(StringUtils.isNotBlank(param.getLeLocal())){
			list.add("leLocal");
			stringParam.append("&&"+CxhcUtil.getParam("leLocal",param.getLeLocal()));
			stringField.append("_leLocal");
		}
		if(StringUtils.isNotBlank(param.getMrcUniversal())){
			list.add("mrcUniversal");
			stringParam.append("&&"+CxhcUtil.getParam("mrcUniversal",param.getMrcUniversal()));
			stringField.append("_mrcUniversal");
		}
		if(StringUtils.isNotBlank(param.getFiscalYear())){
			list.add("fiscalYear");
			stringParam.append("&&"+CxhcUtil.getParam("fiscalYear",param.getFiscalYear()));
			stringField.append("_fiscalYear");
		}
		if(StringUtils.isNotBlank(param.getPeriod())){
			list.add("period");
			stringParam.append("&&"+CxhcUtil.getParam("period",param.getPeriod()));
			stringField.append("_period");
		}
		if(StringUtils.isNotBlank(param.getSourceSystem())){
			list.add("sourceSystem");
			stringParam.append("&&"+CxhcUtil.getParam("sourceSystem",param.getSourceSystem()));
			stringField.append("_sourceSystem");
		}
		if(StringUtils.isNotBlank(param.getAccountType())){
			list.add("accountType");
			stringParam.append("&&"+CxhcUtil.getParam("accountType",param.getAccountType()));
			stringField.append("_accountType");
		}
		if(StringUtils.isNotBlank(param.getAccountsFrom())){
			list.add("accountsFrom");
			stringParam.append("&&"+CxhcUtil.getParam("accountsFrom",param.getAccountsFrom()));
			stringField.append("_accountsFrom");
		}
		if(StringUtils.isNotBlank(param.getAccountsTo())){
			list.add("accountsTo");
			stringParam.append("&&"+CxhcUtil.getParam("accountsTo",param.getAccountsTo()));
			stringField.append("_accountsTo");
		}
		if(StringUtils.isNotBlank(param.getUserInput())){
			list.add("userInput");
			stringParam.append("&&"+CxhcUtil.getParam("userInput",param.getUserInput()));
			stringField.append("_userInput");
		}
		if(StringUtils.isNotBlank(param.getGlobalFunctionalArea())){
			list.add("globalFunctionalArea");
			stringParam.append("&&"+CxhcUtil.getParam("globalFunctionalArea",param.getGlobalFunctionalArea()));
			stringField.append("_globalFunctionalArea");
		}
		String[] str=CxhcUtil.listToArray(list);
		System.out.println(CxhcUtil.getStringByArray(str));
		System.out.println(stringParam);
		System.out.println(stringField);
	}	
}
