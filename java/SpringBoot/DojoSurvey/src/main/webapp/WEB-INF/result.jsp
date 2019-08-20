<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<h1>Submitted Info</h1>
	<p>Name: <c:out value="${ data['name'] }"/></p>
	<p>Dojo Location: <c:out value="${ data['location'] }"/></p>
	<p>Favorite Language: <c:out value="${ data['language'] }"/></p>
	<c:if test="${not empty data['comment'] }" >
		<p>Comment: </p>
		<p><c:out value="${ data['comment'] }"/></p>
	</c:if>
</body>
</html>