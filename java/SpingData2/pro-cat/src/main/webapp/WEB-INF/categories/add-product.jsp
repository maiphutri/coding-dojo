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
<title>Add Product</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1><c:out value="${ cate.name }"/></h1>
		<section class="row">
		<div class="col">
			<h3>Products:</h3>
			<ul>
				<c:forEach items="${ cate.products }" var="product">
					<li>${ product.name }</li>
				</c:forEach>
			</ul>
		</div>
		<div class="col">
			<form:form action="/categories/${ cate.id }/addProduct" method="post" modelAttribute="catPro">
				<div class="form-group">
					<label for="product">Add Category:</label>
					<form:select class="form-control" path="product">
						<form:options items="${ proList }" itemValue="id" itemLabel="name"/>
					</form:select>
				</div>
				<form:hidden path="category" value="${ cate.id }"/>
				<button class="btn btn-info" type="submit">Add</button>
			</form:form>
		</div>
		</section>
	</div>
</body>
</html>