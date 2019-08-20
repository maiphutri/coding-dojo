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
<title>Login Page</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Login</h1>
	    <p><c:out value="${error}" /></p>
	    <form:form method="post" action="/login" modelAttribute="user" class="w-50">
	        <div class="form-group">
	            <label for="email">Email</label>
	            <form:input type="text" path="email" class="form-control"/>
	        </div>
	        <div class="form-group">
	            <label for="password">Password</label>
	            <form:input type="password" path="password" class="form-control"/>
	        </div>
	        <input type="submit" value="Login!" class="btn btn-info"/>
    	</form:form>
	</div>
</body>
</html>