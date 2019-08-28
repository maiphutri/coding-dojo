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
<title>Courses</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1><c:out  value="${ course.name }"/></h1>
		<p>Instructor: <c:out value="${ course.instructor }"/></p>
		<p>Sign Ups: <c:out value="${fn:length(course.users)}" /></p>
		<div class="float-right">
			<a href="/courses/${ course.id }/desc" class="btn btn-info btn-sm">Sign Up Date ASC</a>
			<a href="/courses/${ course.id }/asc" class="btn btn-info btn-sm">Sign Up Date DESC</a>
		</div>
		<table class="table table-striped">
			<thead class="blue lighten-3 white-text">
				<tr>
					<th>Name</th>
					<th>Sign Up Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ courseUser }" var="cU">
				<tr>
					<td><c:out value="${ cU.user.name }"/></td>
					<fmt:formatDate value="${ cU.createdAt }" pattern="MMMM dd, yyyy" var="formattedDate" />
					<td><c:out value="${ formattedDate }"/></td>
					<td>
						<c:if test="${userId == cU.user.id }">
							<a href="/courses/${ course.id }/remove" class="btn btn-danger btn-sm">Remove</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/courses/${ course.id }/edit" class="btn btn-warning">Edit</a>
		<a href="/courses/${ course.id }/delete" class="btn btn-danger">Delete</a>
		
	</div>
</body>
</html>