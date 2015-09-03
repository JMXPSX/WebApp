<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/styles.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />

<script type="text/javascript">
	
	function makeAjaxCall(){
		
		var username = $('#username_field').val();			
		var password = $('#password_field').val(); 
		var type = $('#type_select').val(); 
	    var json = {"username" : username,"password" : password,"type" : type};
	    		
	   $.ajax({
	        url: "SaveAction"+"?jsonRequestdata="+JSON.stringify(json),
	        type: 'POST',
	        dataType: 'json',	        
	        success:function(response){
	        	if(response.errorMessage == null){
	        		alert("SAVE SUCCESS");
	        		$('#username_field').val("");
	        		$('#password_field').val("");
	        	}
	        	if(response.errorMessage == 'username'){
	        		$('#username_field').val("username entry is invalid");
	        	}
	        	if(response.errorMessage == 'password'){
	        		$('#password_field').val("password entry is invalid");
	        	}
	        },
	        error:function(jqXhr, textStatus, errorThrown){
	        	alert(textStatus);
	        } 
	    });	
	   
	}

</script>

<title>ENTRY FORM</title>
</head>
<body>

<s:form cssClass="formBox form-horizontal" theme="bootstrap">
	<div class="form-group">
		  <label>User name:</label>	
		  <s:textfield cssClass="form-control" name="employee.username" id="username_field"/>
	</div>
	<div class="form-group">
		  <label>Password:</label>	  
		  <s:textfield cssClass="form-control" name="employee.password" id="password_field"/>
	</div>
	<div class="form-group">
		   <s:select cssClass="form-control" label="Select Type" list="typeList" name="employee.type" id="type_select"/>
	</div>
	<div class="checkbox">
	  <label><input type="checkbox"> Remember me</label>
	</div>
	<s:submit type="button" label="Submit using AJAX" onclick="makeAjaxCall();return false;"/>
</s:form>

<script src="jquery-1.8.3.js"></script>
</body>
</html>