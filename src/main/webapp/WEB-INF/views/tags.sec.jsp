<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Test of Spring Security Taglibs" />

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.username" var="username" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<c:set value="NOT AUTHENTICATED" var="username" />
</sec:authorize>


<title><c:out value="${title} | ${username}" /></title>
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
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">Spring
					Security Study</a>
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
			<p>
				Simple page that uses some tags in
				<code>http://java.sun.com/jsp/jstl/core</code>
				and
				<code>http://www.springframework.org/security/tags</code>
			<p>
				You are logged as
				<c:out value="${username}" />
			</p>
		</div>

		<div class="row">
			<sec:authorize access="hasRole('ROLE_USER')">
				<div class="col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">For User</div>
						<div class="panel-body">
							<p>This section is only visible to who has the USER role</p>
						</div>
					</div>
				</div>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<div class="col-md-4">
					<div class="panel panel-success">
						<div class="panel-heading">For Admin</div>
						<div class="panel-body">
							<p>This section is only visible to who has the USER role</p>
						</div>
					</div>
				</div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="col-md-4">
					<div class="panel panel-warning">
						<div class="panel-heading">For Authenticated</div>
						<div class="panel-body">
							<p>This section is only visible to who is authenticated</p>
						</div>
					</div>
				</div>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<div class="col-md-4">
					<div class="panel panel-danger">
						<div class="panel-heading">For the others</div>
						<div class="panel-body">
							<p>This section is only visible to who is NOT authenticated</p>
						</div>
					</div>
				</div>
			</sec:authorize>
		</div>

		<div class="row">
			<div class="col-md-12">
				<p>
					Go <a href="javascript:history.back()">back</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>