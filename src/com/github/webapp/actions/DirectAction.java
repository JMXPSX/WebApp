package com.github.webapp.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class DirectAction extends ActionSupport{
	
	private List<String> typeList;
	
	public String execute(){
		
		typeList = new ArrayList<String>();
		
		typeList.add("Regular User");
		typeList.add("Registered User");
		typeList.add("Administrator");
		typeList.add("Secretary");
		typeList.add("Employee");
		
		return SUCCESS;
		
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	
	

}
