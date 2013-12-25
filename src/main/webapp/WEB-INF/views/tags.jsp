<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<%
  java.util.List<String> items = java.util.Arrays.asList("one", "two", "three");
  pageContext.setAttribute("items", items);
%>
<c:set var="title" value="Security Tags" />

<sec:authorize
   access="isAuthenticated()">
  <sec:authentication property="principal.username" var="username" />
</sec:authorize>


<title><c:out value="${title} | ${username}" /></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="styles/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="scripts/jquery.js"></script>
<script src="scripts/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>
				<c:out value="${title}" />
			</h1>
			<p>
				For
				<c:out value="${username}" />
			</p>
		</div>
		<div>
			<sec:authorize access="hasRole('ROLE_USER')">
				<p>You are a USER</p>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<p>You are an ADMIN</p>
			</sec:authorize>
			<p>
				Go <a href="index.html">home</a>
			</p>
		</div>
	</div>
</body>
</html>