<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
		<h1>Questions Dashboard</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ table }" var="row">
				<tr>
					<td><a href="/questions/${ row.id }">${ row.question }</a></td>
					<td>
					<c:forEach items="${ row.tags }" var="tag">
						<c:out value="${ tag.subject }"/>
					</c:forEach>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/questions/new" class="btn btn-info float-right">New Question</a>
	</div>
</body>
</html>