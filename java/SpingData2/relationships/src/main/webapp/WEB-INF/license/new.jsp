<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<form:form action="/licenses" method="post" modelAttribute="license">
			<spring:bind path="person">
				<div class="form-group">
					<label for="firstName">Person</label>
					<form:select class="form-control" path="person">
						<form:options items="${ persons }" itemValue="id" itemLabel="fullName"/>
					</form:select>
				</div>
			</spring:bind>
			<spring:bind path="state">
				<div class="form-group">
					<label for="state">State</label>
					<form:input type="text" class="form-control" path="state" />
				</div>
			</spring:bind>
			<spring:bind path="expirationDate">
				<div class="form-group">
					<label for="expirationDate">Expiration Date:</label>
					<form:input type="date" class="form-control" path="expirationDate" />
				</div>
			</spring:bind>
			<button class="btn btn-primary" type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>