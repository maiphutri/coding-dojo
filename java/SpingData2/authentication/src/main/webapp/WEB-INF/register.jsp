<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Register!</h1>
		
		<p><form:errors path="user.*" /></p>
		
		<form:form action="/register" method="post" modelAttribute="user" class="w-50">
			<p class="form-group">
	            <form:label path="email">Email:</form:label>
	            <form:input type="email" path="email" class="form-control"/>
	        </p>
	        <p class="form-group">
	            <form:label path="password">Password:</form:label>
	            <form:password path="password" class="form-control"/>
	        </p>
	        <p class="form-group">
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password path="passwordConfirmation" class="form-control"/>
	        </p>
	        <input type="submit" value="Register!"/>
		</form:form>
	</div>
</body>
</html>