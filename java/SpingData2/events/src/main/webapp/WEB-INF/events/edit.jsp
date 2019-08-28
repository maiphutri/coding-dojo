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
<title>Edit Events</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1><c:out value="${ event.name }"/></h1>
		<h5>Edit Event</h5>
		<c:if test="${ not empty error}">
			<div  class="alert alert-danger" role="alert"><form:errors path="event.*" /></div>
		</c:if>
		<form:form action="/events/${ event.id }/update" method="POST" modelAttribute="event" class="w-50">
			<div class="form-group">
				<label for="name">Name:</label>
				<form:input type="text" path="name" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="date">Date:</label>
				<form:input type="date" path="date" class="form-control"/>
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
			<button class="btn btn-info" type="submit">Create</button>
			<form:hidden path="host" value="${ user.firstName } ${ user.lastName }"/>
		</form:form>
	</div>
</body>
</html>