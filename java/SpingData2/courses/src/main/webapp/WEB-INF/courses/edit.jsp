<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Edit <c:out value="${ course.name }"/></h1>
		<c:if test="${ not empty error}">
			<div  class="alert alert-danger" role="alert"><form:errors path="course.*" /></div>
		</c:if>
		<form:form action="/courses/${ course.id }/update" method="post" modelAttribute="course" class="w-50">
			<div class="form-group">
				<label for="name">Name:</label>
				<form:input type="text" class="form-control" path="name"/>
			</div>
			<div class="form-group">
				<label for="instructor">Instructor:</label>
				<form:input type="text" class="form-control" path="instructor"/>
			</div>
			<div class="form-group w-25">
				<label for="name">Capacity:</label>
				<form:input type="number" class="form-control" path="capacity"/>
			</div>
			<button class="btn btn-primary" type="submit">Update</button>
		</form:form>
	</div>
</body>
</html>