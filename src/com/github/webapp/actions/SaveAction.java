package com.github.webapp.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.github.webapp.model.Employee;

public class SaveAction extends ActionSupport{
	
	private Employee employee = new Employee();
	private String jsonRequestdata; 
	private String errorMessage;
	
	public String execute(){	
		
		Connection conn = null;
		
		try {
			//Pull request data
	  		JSONObject json;
			json = (JSONObject)new JSONParser().parse(jsonRequestdata);
			
			System.out.println("NAME = " + json.get("username"));
	  		System.out.println("OCCUPATION = " + json.get("password")); 
	  		System.out.println("TYPE = " + json.get("type")); 
	  		
	  		validateOnSubmit(json.get("username"));
	  		if (hasActionErrors()) {
	  			setErrorMessage("username");
	            return INPUT;
	        }
	  		
	  		validateOnSubmit(json.get("password"));
	  		if (hasActionErrors()) {
	  			setErrorMessage("password");
	            return INPUT;
	        }  
	  		
	  		String URL = "jdbc:mysql://localhost/webappdb";
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "");
	        String sql = "INSERT INTO employee "
	        		 + "(username, password, type) VALUES"
	    			 + "(?,?,?)";          
	                  
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, (String) json.get("username"));
	        ps.setString(2, (String) json.get("password")); 
	        ps.setString(3, (String) json.get("type"));
	         
	        ps.executeUpdate();
	  		
		} catch (Exception e) {			
			e.printStackTrace();
			return INPUT;
		}  
		
		return SUCCESS;
	}
	
	private void validateOnSubmit(Object object) {		
			
		String PATTERN = "[A-Za-z0-9 ]+";			
		
		Pattern pattern = Pattern.compile(PATTERN);				
		
		Matcher nameMatcher = pattern.matcher((CharSequence) object);
		
        if (!nameMatcher.matches()) {
        	System.out.println("OBJECT = " + (CharSequence) object);
            addActionError("Special Characters is not valid");	        	
        }
		
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getJsonRequestdata() {
		return jsonRequestdata;
	}

	public void setJsonRequestdata(String jsonRequestdata) {
		this.jsonRequestdata = jsonRequestdata;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
