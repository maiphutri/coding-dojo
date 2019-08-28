<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ event.name }" /></title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${ event.name }" /></h1>
		<main class="row">
			<div class="col">
				<p>Host: <c:out value="${ event.host }" /></p>
				<fmt:formatDate value="${ event.date }" pattern="MMMM dd, yyyy" var="formattedDate" />
				<p><c:out value="${ formattedDate }"/></p>
				<p>Location: <c:out value="${ event.location }, ${ event.state }" /></p>
				<p>People who are attending this event: <c:out value="${ attendants }" /></p>
				<table class="table table-striped">
					<thead class="blue lighten-3 white-text">
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ event.users }" var="user">
							<tr>
								<td><c:out value="${ user.firstName } ${ user.lastName }"/></td>
								<td><c:out value="${ user.location }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="col">
				<h4>Message Wall</h4>
				<div class="wall">
					<ul class="border" id="message-box">
						<c:forEach items="${ messages }" var="message">
							<li><c:out value="${ message.sender }: ${ message.content }"/></li>
						</c:forEach>
					</ul>
				</div>
				<form:form action="/events/${ event.id }/message" method="post" modelAttribute="message">
					<div class="form-group">
						<label for="comment">Add Comment:</label>
						<c:if test="${ not empty error}">
							<div  class="alert alert-danger" role="alert"><form:errors path="content" /></div>
						</c:if>
						<form:textarea path="content" class="form-control"></form:textarea>
					</div>
					<button class="btn btn-info">Send</button>
					<form:hidden path="sender" value="${ user.firstName } ${ user.lastName }"/>
					<form:hidden path="event" value="${ event.id }"/>
				</form:form>
				
			</div>
		</main>
	</div>
</body>
</html>