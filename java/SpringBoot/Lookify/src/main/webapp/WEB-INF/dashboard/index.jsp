<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark primary-color">
		<div class="container">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
		    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav mx-auto">
		    	<li class="nav-item">
			        <a class="nav-link" href="/songs/new">Add New</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="/search/topTen">Top Songs</a>
			    </li>
		        <li>
			      	<form class="form-inline my-2 my-lg-0 ml-auto" action="/search" method="post">
				    	<input class="form-control" type="search" placeholder="Search" aria-label="Search" name="artist">
				        <button class="btn btn-outline-white btn-md my-2 my-sm-0 ml-3" type="submit">Search Artists</button>
				  	</form>
		        </li>
		    </ul>
		  </div>
		</div>
	</nav>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/songs/${ song.id }">${ song.title }</a></td>
						<td>${ song.rating }</td>
						<td>
							<form action="/songs/${ song.id }/delete" method="post">
								<button type="submit" class="btn btn-danger btn-sm">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>