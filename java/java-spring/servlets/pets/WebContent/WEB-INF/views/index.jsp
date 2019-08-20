<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pets</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.7/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
			<h1>Create a Dog</h1>
			<form action="/pets/dogs" method="post">
				<div class="form-group">
					<label>Name</label>
					<input type="text" name="name"/>
				</div>
				<div class="form-group">
					<label>Breed</label>
					<input type="text" name="breed"/>
				</div>
				<div class="form-group">
					<label>Weight</label>
					<input type="number" name="weight" step="0.01"/>
				</div>
				<button class="btn btn-primary" type="submit">Create</button>
			</form>
			</div>
			<div class="col">
			<h1>Create a Cat</h1>
			<form action="/pets/cats" method="post">
				<div class="form-group">
					<label>Name</label>
					<input type="text" name="name"/>
				</div>
				<div class="form-group">
					<label>Breed</label>
					<input type="text" name="breed"/>
				</div>
				<div class="form-group">
					<label>Weight</label>
					<input type="number" name="weight" step="0.01"/>
				</div>
				<button class="btn btn-primary" type="submit">Create</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>