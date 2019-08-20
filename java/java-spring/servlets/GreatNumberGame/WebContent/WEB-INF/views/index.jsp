<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
<title>Great Number Game</title>
</head>
<body>
	<div class="container text-center">
		<h1>Welcome to the Great Number Game!</h1>
		<h4>I'm thinking of a number between 1 and 100</h4>
		<h4>Take a guess!</h4>
		<div class="result-square">
			<c:out value="${ result }" />
		</div>
		<c:if test="${result == 'Correct!'}">
			<a href="/home/reset" class="btn btn-info btn-sm">Reset</a>
		</c:if> 
		<form action="/home/" method="post">
			<input type="number" min="1" max="100" name="number">
			</br>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>