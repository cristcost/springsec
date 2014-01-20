<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html>
<head>

<c:set var="title" value="Secured GWT Application" />

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title><c:out value="${title}" /></title>
<link href="${pageContext.request.contextPath}/styles/bootstrap.min.css"
	rel="stylesheet" media="screen">

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.username" var="username" />
</sec:authorize>

<script type="text/javascript">
	var getPageConfig = {
		"username" : "${username}",
		"tagServiceEndpoint" : "${pageContext.request.contextPath}/secured/gwt.servlet",
	};
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/secureme/secureme.nocache.js"></script>

</head>
<body style="padding-top: 60px;">
	<iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1'
		style="position: absolute; width: 0; height: 0; border: 0"></iframe>

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
			<sec:authorize access="isAuthenticated()">
				<p>
					Logged as
					<sec:authentication property="principal.username" />
				</p>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<p>You are not logged</p>
			</sec:authorize>
		</div>

		<div class="row">
			<ul class="nav nav-tabs">
				<li><a href="#list:">Home</a></li>
				<sec:authorize access="isAuthenticated()">
					<li><a href="#add:">Add</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="#admin:">Admin</a></li>
				</sec:authorize>
			</ul>
			<div id="application"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p>
					Go <a href="javascript:history.back()">back</a> or go <a
						href="${pageContext.request.contextPath}/index.html">home</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
