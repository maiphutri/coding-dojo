<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<script src="js/time.js" type="text/javascript"></script>
	<h1 class="green"><c:out value="${ time }"/></h1>
</body>
</html>