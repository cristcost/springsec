<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Error 403" />

<title><c:out value="${title}"/></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${pageContext.request.contextPath}/styles/bootstrap.min.css"
	rel="stylesheet" media="screen">

</head>
<body style="padding-top: 60px;">
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">Spring Security Study</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li><a
					href="${pageContext.request.contextPath}/secured/login.html">Login</a>
				</li>
				<li><a href="${pageContext.request.contextPath}/secured/logout">Logout
				</a></li>
			</ul>
		</div>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h1>
				<c:out value="${title}" />
			</h1>
			<p>You are not authorized to access this resource</p>
		</div>
		<div>
			<p>
				Go <a href="${pageContext.request.contextPath}/index.html">home</a>
			</p>
		</div>
	</div>
</body>
</html>