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
<title>New Product</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		<form:form action="/products" method="post" modelAttribute="product" class="w-25">
			<div class="form-group">
				<label for="name">Name</label>
				<form:input type="text" path="name" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="desc">Description</label>
				<form:textarea path="description" class="form-control"></form:textarea>
			</div>
			<div class="form-group">
				<label for="name">Price</label>
				<form:input type="number" step=".01" path="price" class="form-control"/>
			</div>
			<button class="btn btn-info">Create</button>
		</form:form>
	</div>
</body>
</html>