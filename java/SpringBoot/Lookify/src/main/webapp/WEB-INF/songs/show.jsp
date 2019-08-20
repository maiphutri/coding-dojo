<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../static/partials/navbar.jsp"></jsp:include>
	<div class="container text-center mt-3" >
		<div class="content">
			<p>Title: <c:out value="${song.title}"/></p>
			<p>Artist: <c:out value="${song.artist}"/></p>
			<p>Rating: <c:out value="${song.rating}"/></p>
			<form action="/songs/${ song.id }/delete" method="post">
				<button type="submit" class="btn btn-danger">Delete</button>
			</form>
		</div>
	</div>
</body>
</html>