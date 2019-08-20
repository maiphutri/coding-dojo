<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo</title>
</head>
<body>
	<%!
	public int add(int a, int b) {
		return a + b;
	}
	%>
	
	<%
	int i = 2;
	int j = 4;
	%>
	
	<h3><%= add(i, j) %></h3>
	
	<% for (int index=0; index < 4; index++) { %>
		<h1><%= index %></h1>
	<% } %>
</body>
</html>