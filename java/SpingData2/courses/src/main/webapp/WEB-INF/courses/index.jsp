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
		<header class="row">
			<div class="col col-md-9">
				<h1>Welcome, <c:out value="${ user.name }"/></h1>
			</div>
			<div class="col col-md-3">
				<a href="/logout" class="btn btn-secondary">Logout</a>
			</div>
		</header>
		<main>
			<div class="row">
				<div class="col col-md-8">
					<h5>Courses</h5>
				</div>
				<div class="col col-md-4">
					<a href="/courses/desc" class="btn btn-info btn-sm d-inline">Low Sign Up</a>
					<a href="/courses/asc" class="btn btn-info btn-sm">High Sign Up</a>
				</div>
			</div>
			
			<table class="table table-striped">
				<thead class="blue lighten-3 white-text">
					<tr>
						<th>Course</th>
						<th>Instructor</th>
						<th>Signups</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ courses }" var="course">
						<tr>
							<td><a href="/courses/${ course.id }" class="deep-purple-text"><c:out value="${ course.name }"/></a></td>
							<td><c:out value="${ course.instructor }"/></td>
							<td><c:out value="${fn:length(course.users)}/${ course.capacity }"/></td>
							<td>
							<c:set var='isAdded' value="false"/>
		  					<c:forEach items="${ course.users }" var="u">
		  						<c:if test="${ u.id == user.id }">
		  							<c:set var="isAdded" value="true" />
		  						</c:if>
		  					</c:forEach>
							<c:choose>
								<c:when test="${fn:length(course.users) == course.capacity  }">
									<button class="btn btn-danger btn-sm" disabled>Full</button>
								</c:when>
								<c:when test="${ isAdded == true }">
									<button class="btn btn-secondary btn-sm" disabled>Already Added</button>
								</c:when>
								<c:otherwise>
									<form:form action="/courses/${ course.id }/add" method="post" modelAttribute="courseUser">
										<form:hidden path="user" value="${ user.id }"/>
										<form:hidden path="course" value="${ course.id }"/>
										<button class="btn btn-info btn-sm" type="submit">Add</button>
									</form:form>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a class="btn btn-success" href="/courses/new">Add a course</a>
		</main>
	</div>
</body>
</html>