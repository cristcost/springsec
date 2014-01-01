<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Index Page" />
<title><c:out value="${title}" /></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="styles/bootstrap.min.css" rel="stylesheet" media="screen">

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>GWT In ServiceMix Example</h1>
			<p>HTML template</p>
		</div>
		<p>
			Go to <a href="gwt.html" title="Require ADMIN role">GWT Demo
				Application</a><br /> or go to <a href="demo.html"
				title="Require USER role">Simple Demo Application</a><br /> or see
			the Spring Security <a href="tags.html" title="Any role">Taglibs</a>
			in action<br /> or open a <a href="http-request-handler.servlet"
				title="Require no one is authenticated!">Spring
				HttpRequestHandler</a><br /> or a <a href="standard.servlet"
				title="Require authenticated">Standard Servlet</a> that is handled
			by Spring MVC Dispatcher and injected with Spring beans.
		</p>

		<p>
			What if the servlet is not filtered with springSecurityFilterChain?<br />
			Let see on the <a href="unfiltered/http-request-handler.servlet">Spring
				HttpRequestHandler</a><br /> or the <a
				href="unfiltered/standard.servlet">Standard Servlet</a>
		</p>

		<p>
			Do <a href="logout">logout</a> (i don't know if you are logged or
			not, check <a href="tags.html" title="Any role">Taglibs</a> page for
			that).
		</p>

	</div>
</body>
</html>