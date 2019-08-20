<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<h1>New Dojo</h1>
		<form:form action="/dojos" method="post" modelAttribute="dojo">
			<div class="form-group">
				<label for="state">Name:</label>
				<form:input type="text" path="name"/>
			</div>
			<button class="btn btn-info" type="submit">Create</button>
		</form:form>
	</div>
</body>
</html>