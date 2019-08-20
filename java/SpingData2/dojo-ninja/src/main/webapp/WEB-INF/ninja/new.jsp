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
		<h1>New Ninja</h1>
		<form:form action="/ninjas" method="post" modelAttribute="ninja" class="w-25">
			<div class="form-group">
				<label for="dojo">Dojo:</label>
				<form:select class="form-control" path="dojo">
					<form:options items="${ dojos }" itemValue="id" itemLabel="name"/>
				</form:select>
			</div>
			<div class="form-group">
				<label for="fn">First Name:</label>
				<form:input type="text" path="firstName" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="ln">Last Name:</label>
				<form:input type="text" path="lastName" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="age">Age:</label>
				<form:input type="number" path="age" class="form-control"/>
			</div>
			<button class="btn btn-info" type="submit">Create</button>
		</form:form>
	</div>
</body>
</html>