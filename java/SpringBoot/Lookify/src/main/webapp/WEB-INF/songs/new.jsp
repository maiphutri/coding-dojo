<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Song</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../static/partials/navbar.jsp"></jsp:include>
	<div class="container mt-3">
		<form:form action="/songs" method="post" modelAttribute="song" class="w-25 mx-auto">
		<spring:bind path="title" >
			<div class="form-group">
			  <label for="form1">Title</label>
			  <div class="alert alert-danger p-0 pl-2 ${status.error ? 'has-error' : 'd-none' }" role="alert" >
			  	<form:errors path="title"/>
			  </div>
			  <form:input type="text" class="form-control" path="title" />
			</div>
		</spring:bind>
		<spring:bind path="artist" >
			<div class="form-group">
			  <label for="form1">Artist</label>
			  <div class="alert alert-danger p-0 pl-2 ${status.error ? 'has-error' : 'd-none' }" role="alert" >
			  	<form:errors path="artist"/>
			  </div>
			  <form:input type="text" class="form-control" path="artist" />
			</div>
		</spring:bind>
		<spring:bind path="rating" >
			<div class="form-group">
			  <label for="form1">Rating</label>
			  <div class="alert alert-danger p-0 pl-2 ${status.error ? 'has-error' : 'd-none' }" role="alert" >
			  	<form:errors path="rating"/>
			  </div>
			  <form:input type="number" class="form-control" path="rating" />
			</div>
		</spring:bind>
		<div class="text-center">
			<button class="btn btn-success" type="submit">Add Song</button>
		</div>
		</form:form>
	</div>
</body>
</html>