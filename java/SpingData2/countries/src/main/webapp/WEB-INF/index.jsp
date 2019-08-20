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
		<h3>Get all the countries that speak Slovene</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Country</th>
					<th>Language</th>
					<th>Language %</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ firstTask }" var="row">
					<tr>
						<td>${ row[0].name }</td>
						<td>${ row[1].language }</td>
						<td>${ row[1].percentage }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Display the total number of cities for each country</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Country</th>
					<th>Total Cities</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ secondTask }" var="row">
					<tr>
						<td>${ row[0] }</td>
						<td>${ row[1] }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Get all the cities in Mexico with a population of greater than 500,000</h3>
		<table class="table">
			<thead>
				<tr>
					<th>City</th>
					<th>Population</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ thirdTask }" var="row">
					<tr>
						<td>${ row[0] }</td>
						<td>${ row[1] }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Get all languages in each country with a percentage greater than 89%</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Country</th>
					<th>Language Percentage</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ fourthTask }" var="row">
					<tr>
						<td>${ row[0] }</td>
						<td>${ row[1] }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>