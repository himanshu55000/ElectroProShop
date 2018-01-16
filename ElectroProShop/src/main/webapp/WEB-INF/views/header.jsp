<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<c:url var="e" value="/"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><title>Home Page</title>
  <style>
  .footlink{
  color:#FFF;
  }
  .footlink:hover{
  color:#FFF;
  text-decoration:none;
  }
  .footlink:visited{
  color:#FFF;
  }
  </style>
  </head>
<body style="background:#eee">
<header>
<nav class="navbar navbar-inverse" style="margin:0">
  <div class="container-fluid">
    <div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#homeNav">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="#">Home</a>
    </div>
    <div class="collapse navbar-collapse" id="homeNav">
     <ul class="nav navbar-nav">
	<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Jeans</a></li>
          <li><a href="#">Shirt</a></li>
          <li><a href="#">Shoes</a></li>
        </ul>
      </li>
    </ul>
	<ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="fa fa-user"></span> Register</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
    </ul>
  </div></div>
</nav>
</header>
