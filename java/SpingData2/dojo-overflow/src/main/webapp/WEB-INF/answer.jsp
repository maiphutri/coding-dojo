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
		<h1><c:out value="${ question.question }"/></h1>
		<h5>Tags: 
		<c:forEach items="${ question.tags }" var="tag">
			<span class="badge badge-pill badge-primary"><c:out value="${ tag.subject }"/></span>
		</c:forEach>
		</h5>
		<div class="row">
			<div class="col border border-secondary">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Answers</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ answers }" var="answer">
						<tr>
							<td>
								<c:out value="${ answer.answer }"/>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
			</div>
			<div class="col">
			<h5>Add your answer:</h5>
			<form:form action="/questions/${ question.id }" method="post" modelAttribute="answerModel">
				<div class="form-group">
					<spring:bind path="answer">
						<c:if test="${status.error == true}">
							<p class="alert alert-danger" role="alert"><form:errors path="answer"/></p>
						</c:if>
						<label for="answer">Answer:</label>
						<form:textarea path="answer" class="form-control textarea"></form:textarea>
					</spring:bind>
				</div>
				<button type="submit" class="btn btn-success">Submit</button>
				<form:hidden path="question" value="${ question.id }"/>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>