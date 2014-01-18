<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>

<title>${title}</title>
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
			<h1>${title}</h1>
			<p>${page_description}</p>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p>Your authentication information is the following:</p>
				<pre class="code"><sec:authentication property="principal" /></pre>
			</div>
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