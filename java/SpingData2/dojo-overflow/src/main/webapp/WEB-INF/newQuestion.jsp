<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" %>
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
	<h1>What is your question?</h1>
	<form:form action="/questions" method="POST" modelAttribute="Ques" class="w-50">
		<div class="form-group">
			<label for="question">Question:</label>
			<br />
			<form:errors path="question" class="alert alert-danger p-0" role="alert"/>
			<form:textarea path="question" class="form-control"></form:textarea>
		</div>
		<div class="form-group">
			<label for="tags">Tags</label>
			<c:if test="${not empty tagErr}">
				<div class="alert alert-danger p-0" role="alert">
					<c:out value="${ tagErr }"/> 
				</div>
			</c:if>
			<input type="text" name="tag" class="form-control" value="${ tag }"/>
		</div>
		<button class="btn btn-info" type="submit">Submit</button>
	</form:form>
	</div>
</body>
</html>