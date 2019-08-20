<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checker Board</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<% int w = request.getParameter("width") == null ? 8 : Integer.valueOf(request.getParameter("width")); %>
	<% int h = request.getParameter("height") == null ? 8 : Integer.valueOf(request.getParameter("height")); %>
	
	<div class="container">
		<h1>Checker board</h1>
		<% for (int i=1; i <= h; i++) { %>
			<div class="row">
			<% for (int j=1; j <= w; j++) { %>
				<% if (i % 2 == 0) { %>
					<div class="square even"></div>
				<% } else { %>
					<div class="square odd"></div>
				<% } %>
			<% } %>
		<% } %>
		</div>
	</div>
</body>
</html>