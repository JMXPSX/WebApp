<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/styles.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />

<title>Web Application</title>
</head>
<body>  

	<s:form action="DirectAction" method="post">
		<!-- Button -->
		<div class="form-group">			   
		   <div class="col-lg-5 center-block">			   
		       <s:submit type="button" cssClass="btn btn-info btn-lg" label="Struts 2 Next Page" />
		   </div>  
		</div>
	</s:form>
     
<script src="jquery-1.8.3.js"></script>
</body>
</html>