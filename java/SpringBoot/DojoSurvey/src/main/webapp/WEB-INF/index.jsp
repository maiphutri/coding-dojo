<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
</head>
<body>
	<form action="/" method="post" >
		<p>Name:
			<input type="text" name="name"/>
		</p>
		<p>Dojo Location:
			<select name="location">
				<option value="San Jose">San Jose</option>
				<option value="Burbank">Burbank</option>
				<option value="Seatle">Seatle</option>
			</select>
		</p>
		<p>Favorite Language: 
			<select name="language">
				<option value="Python">Python</option>
				<option value="Java">Java</option>
				<option value="JavaScript">JavaScript</option>
			</select>
		</p>
		<p>Comment (optional):</p>
		<textarea row="10" col="10"name="comment"></textarea>
		<button type="submit">Submit</button>
	</form>
</body>
</html>