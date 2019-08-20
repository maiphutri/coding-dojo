<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
    <div class='header'>
      <h4>Your Gold: <c:out value="${ gold }"/></h4>
      <form action="/reset" method="POST" class='reset-btn'>
        <input type='submit' class="btn btn-danger btn-sm" value="Reset">
      </form>
    </div>
    <div class="card-group">
      <div class="card">
        <img class="card-img-top" src="images/farm.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Farm</h5>
          <p class="card-text">Earns 10-20 golds</p>
          <form action="/process_money" method="POST">
            <input type="hidden" name="building" value="farm">
            <input type="submit" value="Find Gold" class="btn btn-primary btn-sm">
          </form>
        </div>
      </div>
      <div class="card">
        <img class="card-img-top" src="images/cave.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Cave</h5>
          <p class="card-text">Earns 5-10 golds</p>
          <form action="/process_money" method="POST">
            <input type="hidden" name="building" value="cave">
            <input type="submit" value="Find Gold" class="btn btn-primary btn-sm">
          </form>
        </div>
      </div>
      <div class="card">
        <img class="card-img-top" src="images/house.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">House</h5>
          <p class="card-text">Earns 2-5 golds</p>
          <form action="/process_money" method="POST">
            <input type="hidden" name="building" value="house">
            <input type="submit" value="Find Gold" class="btn btn-primary btn-sm">
          </form>
        </div>
      </div>
      <div class="card">
        <img class="card-img-top" src="images/casino.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Casino</h5>
          <p class="card-text">Earns/lost 0-50 golds</p>
          <form action="/process_money" method="POST">
            <input type="hidden" name="building" value="casino">
            <input type="submit" value="Find Gold" class="btn btn-primary btn-sm">
          </form>
        </div>
      </div>
    </div>
    
    <h5 id="activities">Activities: </h5>

    <div class="activities">
      <ul>
		<c:forEach items="${ activities }" var="item">
			<li class="${ item['isLost'] }"><c:out value="${ item['msg']}" /></li>
		</c:forEach>
      </ul>
    </div>
  </div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
  function updateScroll(){
    var element = document.querySelector(".activities");
    element.scrollTop = element.scrollHeight;
  }
  updateScroll()
</script>
</body>
</html>