<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>

<c:set var="title" value="Hacked GWT Application" />

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title><c:out value="${title}" /></title>
<link href="${pageContext.request.contextPath}/styles/bootstrap.min.css"
	rel="stylesheet" media="screen">

<script type="text/javascript">
	var getPageConfig = {
		"tagServiceEndpoint" : "${pageContext.request.contextPath}/secured/gwt.servlet",
		"activities" : [ "list", "add", "admin" ]
	};
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/secureme/secureme.nocache.js"></script>

</head>
<body>
	<iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1'
		style="position: absolute; width: 0; height: 0; border: 0"></iframe>
	<div class="container">
		<div class="jumbotron">
			<h1>
				<c:out value="${title}" />
			</h1>
		</div>
		<p>
			Go <a href="${pageContext.request.contextPath}/index.html">home</a>
		</p>
		<ul class="nav nav-tabs">
			<li><a href="#list:">Home</a></li>
			<li><a href="#add:">Add</a></li>
			<li><a href="#admin:">Admin</a></li>
		</ul>
		<div id="application"></div>
	</div>
</body>
</html>
