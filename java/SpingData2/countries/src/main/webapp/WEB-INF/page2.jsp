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
		<h3>Get all the countries with Surface Area below 501 and Population greater than 100,000</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Country</th>
					<th>Surface Area</th>
					<th>Population<th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ fifthTask }" var="row">
					<tr>
						<td>${ row[0] }</td>
						<td>${ row[1] }</td>
						<td>${ row[2] }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h5>get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years</h5>
		<table class="table">
			<thead>
				<tr>
					<th>Country</th>
					<th>Government Form</th>
					<th>Surface Area<th>
					<th>Life Expectancy</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ sixTask }" var="row">
					<tr>
						<td>${ row[0] }</td>
						<td>${ row[1] }</td>
						<td>${ row[2] }</td>
						<td>${ row[3] }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>All the cities of Argentina inside the Buenos Aires district </h3>
		<table class="table">
			<thead>
				<tr>
					<th>Country</th>
					<th>City</th>
					<th>District<th>
					<th>Population</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ sevenTask }" var="row">
					<tr>
						<td>${ row[0] }</td>
						<td>${ row[1] }</td>
						<td>${ row[2] }</td>
						<td>${ row[3] }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Summarize the number of countries in each region</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Region</th>
					<th>Number of Countries</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ finalTask }" var="row">
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