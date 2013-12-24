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
		<div id="gwtApp">
			Go to <a href="gwt.html">GWT Demo Application</a> or to <a
				href="demo.html">Simple Demo Application</a>
		</div>
		
		<p>Do <a href="logout">logout</a></p>
		
	</div>
</body>
</html>