<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
       <c:if test='<%=(Boolean)session.getAttribute("loggedIn")!=null&&(Boolean)session.getAttribute("loggedIn")==true%>'>
	 <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          					<c:forEach items="${sessionScope.categoryList}" var="cat">
					<li><a href="${e}products/${cat.cid}">${cat.categoryName}</a></li>		
					</c:forEach>
        </ul>
      </li></c:if>
     </ul>
	<ul class="nav navbar-nav navbar-right">
       <c:if test='<%=(Boolean)session.getAttribute("loggedIn")!=null&&(Boolean)session.getAttribute("loggedIn")==true%>'>
        <sec:authentication var="user" property="principal" />
          <c:if test="${user.authorities=='[ROLE_ADMIN]'}">
          <li><a href="${e}admin/addDetailsAdmin">Add Details</a></li>
		<li><a href="${e}admin/viewDetailsAdmin">View Details</a></li>
	</c:if>
	<li><a href="${e}cart">
      <span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;Cart</a>
      </li> 
	<li><a>Welcome ${user.username}</a></li>   
   <li><a href="<c:url value="/perform_logout"/>">
         <span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
         
         </c:if>
        <c:if test='<%=(Boolean)session.getAttribute("loggedIn")==null%>'>
 <li><a href="${e}register"><span class="fa fa-user"></span> Register</a></li>
      <li><a href="${e}login"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
    </c:if></ul>
  </div></div>
</nav>
</header>
