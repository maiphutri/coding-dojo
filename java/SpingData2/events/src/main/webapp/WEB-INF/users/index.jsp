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
<title>Welcome</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Welcome to the Events Project</h1>
		<main class="row">
			<div class="col">
				<h3>Register</h3>
				<c:if test="${ not empty regError}">
					<div  class="alert alert-danger" role="alert"><form:errors path="user.*" /></div>
				</c:if>
				<form:form action="/register" method="POST" modelAttribute="user">
					<div class="form-group">
						<label for="fn">First Name:</label>
						<form:input type="text" path="firstName" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="ln">Last Name:</label>
						<form:input type="text" path="lastName" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<form:input type="text" path="email" class="form-control"/>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col col-md-8">
								<label for="location">Location:</label>
								<form:input type="text" path="location" class="form-control"/>
							</div>
							<div class="col col-md-4">
								<label for="state">State:</label>
								<form:select path="state" class="form-control">
									<form:option value="AL">Alabama</form:option>
									<form:option value="AK">Alaska</form:option>
									<form:option value="AZ">Arizona</form:option>
									<form:option value="AR">Arkansas</form:option>
									<form:option value="CA">California</form:option>
									<form:option value="CO">Colorado</form:option>
									<form:option value="CT">Connecticut</form:option>
									<form:option value="DE">Delaware</form:option>
									<form:option value="FL">Florida</form:option>
									<form:option value="GA">Georgia</form:option>
									<form:option value="HI">Hawaii</form:option>
									<form:option value="ID">Idaho</form:option>
									<form:option value="IL">Illinois</form:option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<form:password path="password" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="pwCf">Password Confirmation:</label>
						<form:password path="passwordConfirmation" class="form-control"/>
					</div>
					<button class="btn btn-success float-right">Register</button>
				</form:form>
			</div>
			<div class="col">
				<h3>Login</h3>
				<c:if test="${ not empty logError}">
					<div  class="alert alert-danger" role="alert"><c:out value="${ logError }"/></div>
				</c:if>
				<form action="/login" method="POST" >
					<div class="form-group">
						<label for="email">Email:</label>
						<input type="text" name="emailLog" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<input type="password" name="password" class="form-control"/>
					</div>
					<button class="btn btn-success float-right">Login</button>
				</form>
			</div>
		</main>
	</div>
</body>
</html>