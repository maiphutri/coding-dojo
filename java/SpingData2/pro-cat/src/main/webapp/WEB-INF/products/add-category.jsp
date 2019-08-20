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
<title>Add Category</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1><c:out value="${ product.name }"/></h1>
		<section class="row">
		<div class="col">
			<h3>Categories:</h3>
			<ul>
				<c:forEach items="${ product.categories }" var="cate">
					<li>${ cate.name }</li>
				</c:forEach>
			</ul>
		</div>
		<div class="col">
			<form:form action="/products/${ product.id }/addCategory" method="post" modelAttribute="catPro">
				<div class="form-group">
					<label for="category">Add Category:</label>
					<form:select class="form-control" path="category">
						<form:options items="${ cateList }" itemValue="id" itemLabel="name"/>
					</form:select>
				</div>
				<form:hidden path="product" value="${ product.id }"/>
				<button class="btn btn-info" type="submit">Add</button>
			</form:form>
		</div>
		</section>
	</div>
</body>
</html>