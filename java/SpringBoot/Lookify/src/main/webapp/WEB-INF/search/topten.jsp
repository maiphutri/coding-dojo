<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
<title>Top Ten</title>
</head>
<body>
	<jsp:include page="../static/partials/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>Top Ten Songs</h1>
		<ul style="list-style:none">
			<c:forEach items="${ songs }" var="song">
				<li>${ song.rating } - <a href="/songs/${ song.id }"> ${ song.title }</a> - ${ song.artist }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>