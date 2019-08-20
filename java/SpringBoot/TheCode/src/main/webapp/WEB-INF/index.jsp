<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>What is the code?</h1>
	<c:out value="${ error }"/>
	<form action="/" method="post" >
		<input type="text" name="code"/>
		<button type="submit">Try Code</button>
	</form>
</body>
</html>