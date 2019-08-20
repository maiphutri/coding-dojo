<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>New Person</h1>
		<form:form action="/person" method="post" modelAttribute="person">
			<spring:bind path="firstName">
				<div class="form-group">
					<label for="firstName">Fist Name:</label>
					<form:input type="text" class="form-control" path="firstName" />
				</div>
			</spring:bind>
			<spring:bind path="lastName">
				<div class="form-group">
					<label for="firstName">Last Name:</label>
					<form:input type="text" class="form-control" path="lastName" />
				</div>
			</spring:bind>
			<button class="btn btn-primary" type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>