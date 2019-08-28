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
<title>Events</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<header class="row">
			<div class="col col-md-9">
				<h1>Welcome, <c:out value="${ user.firstName }"/></h1>
			</div>
			<div class="col col-md-3">
				<a href="/logout" class="btn btn-secondary">Logout</a>
			</div>
		</header>
		
		<main>
			<h5>Here are some of the events in your state:</h5>
			<table class="table table-striped">
				<thead class="blue lighten-3 white-text">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Date</th>
				      <th scope="col">Location</th>
				      <th scope="col">Host</th>
				      <th scope="col">Action/Status</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${ stateEvents }" var="event">
				  		<tr>
				  			<td><a href="/events/${ event.id }" class="deep-purple-text"><c:out value="${ event.name }"/></a></td>
				  			<fmt:formatDate value="${ event.date }" pattern="MMMM dd, yyyy" var="formattedDate" />
				  			<td><c:out value="${ formattedDate }"/></td>
				  			<td><c:out value="${ event.location }"/></td>
				  			<td><c:out value="${ event.host }"/></td>
				  			<c:choose>
				  				<c:when test="${ event.host == hostName }">
				  				<td>
				  					<a class="btn btn-warning btn-sm" href="/events/${ event.id }/edit">Edit</a>
				  					<a class="btn btn-danger btn-sm" href="/events/${ event.id }/delete">Delete</a>
				  				</td>
				  				</c:when>
				  				<c:otherwise>
				  				<td>
				  					<c:set var='isJoin' value="false"/>
				  					<c:forEach items="${ event.users }" var="u">
				  						<c:if test="${ u.id == user.id }">
				  							<c:set var="isJoin" value="true" />
				  						</c:if>
				  					</c:forEach>
				  					<c:choose>
				  						<c:when test="${ isJoin == true }">
				  							<button class="btn btn-success btn-sm">Joining</button>
				  						</c:when>
				  						<c:otherwise>
				  							<form:form action="/events/${ event.id }/join" method="post" modelAttribute="eventUser" class="d-inline-block">
						  						<form:hidden path="event" value="${ event.id }"/>
						  						<form:hidden path="user" value="${ user.id }" />
						  						<button class="btn btn-info btn-sm" type="submit">Join</button>
						  					</form:form>
				  						</c:otherwise>
				  					</c:choose>
				  					<a class="btn btn-warning btn-sm" href="/events/${ event.id }/cancel">Cancel</a>
				  				</td>
				  				</c:otherwise>
				  			</c:choose>
				  		</tr>
				  	</c:forEach>
				  </tbody>
			</table>
			<h5>Here are some of the events in other states:</h5>
			<table class="table table-striped">
				<thead class="blue lighten-3 white-text">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Date</th>
				      <th scope="col">Location</th>
				      <th scope="col">State</th>
				      <th scope="col">Host</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${ otherEvents }" var="event">
				  	<tr>
				  		<td><a href="/events/${ event.id }" class="deep-purple-text"><c:out value="${ event.name }" /></a></td>
				  		<fmt:formatDate value="${ event.date }" pattern="MMMM dd, yyyy" var="formattedDate" />
				  		<td><c:out value="${ formattedDate }"/></td>
				  		<td><c:out value="${ event.location }" /></td>
				  		<td><c:out value="${ event.state }" /></td>
				  		<td><c:out value="${ event.host }" /></td>
				  		<c:choose>
		  				<c:when test="${ event.host == hostName }">
		  				<td>
		  					<a class="btn btn-warning btn-sm" href="/events/${ event.id }/edit">Edit</a>
		  					<a class="btn btn-danger btn-sm" href="/events/${ event.id }/delete">Delete</a>
		  				</td>
		  				</c:when>
		  				<c:otherwise>
				  		<td>
				  			<c:set var='isJoin' value="false"/>
				  			<c:forEach items="${ event.users }" var="u">
				  				<c:if test="${ u.id == user.id }">
				  					<c:set var="isJoin" value="true" />
				  				</c:if>
				  			</c:forEach>
				  			<c:choose>
		  						<c:when test="${ isJoin == true }">
		  							<button class="btn btn-success btn-sm">Joining</button>
		  						</c:when>
		  						<c:otherwise>
		  							<form:form action="/events/${ event.id }/join" method="post" modelAttribute="eventUser" class="d-inline-block">
				  						<form:hidden path="event" value="${ event.id }"/>
				  						<form:hidden path="user" value="${ user.id }" />
				  						<button class="btn btn-info btn-sm" type="submit">Join</button>
				  					</form:form>
		  						</c:otherwise>
		  					</c:choose>
		  					<a class="btn btn-warning btn-sm" href="/events/${ event.id }/cancel">Cancel</a>
		  				</td>
		  				</c:otherwise>
				  	</c:choose>
				  	</tr>
				  </c:forEach>
				  </tbody>
			</table>
			<h5>Create an Event</h5>
			<c:if test="${ not empty error}">
				<div  class="alert alert-danger" role="alert"><form:errors path="event.*" /></div>
			</c:if>
			<form:form action="/events" method="POST" modelAttribute="event" class="w-50">
				<div class="form-group">
					<label for="name">Name:</label>
					<form:input type="text" path="name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="date">Date:</label>
					<form:input type="date" path="date" class="form-control"/>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col col-md-8">
							<label for="location">Location:</label>
							<form:input type="text" path="location" class="form-control"/>
						</div>
						<div class="col col-md-4">
							<label for="state">State:</label>
							<form:select path="state" class="form-control">
								<form:option value="AL">Alabama</form:option>
								<form:option value="AK">Alaska</form:option>
								<form:option value="AZ">Arizona</form:option>
								<form:option value="AR">Arkansas</form:option>
								<form:option value="CA">California</form:option>
								<form:option value="CO">Colorado</form:option>
								<form:option value="CT">Connecticut</form:option>
								<form:option value="DE">Delaware</form:option>
								<form:option value="FL">Florida</form:option>
								<form:option value="GA">Georgia</form:option>
								<form:option value="HI">Hawaii</form:option>
								<form:option value="ID">Idaho</form:option>
								<form:option value="IL">Illinois</form:option>
							</form:select>
						</div>
					</div>
				</div>
				<button class="btn btn-info" type="submit">Create</button>
				<form:hidden path="host" value="${ user.firstName } ${ user.lastName }"/>
			</form:form>
		</main>
	</div>
</body>
</html>