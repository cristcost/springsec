<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%> --%>

<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Log In" />

<title><c:out value="${title}" /></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="styles/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="scripts/jquery.js"></script>
<script src="scripts/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Sign-In</h3>
			</div>
			<div class="panel-body">
				<c:if test="${not empty param.login_error}">
					<div class="alert alert-danger alert-dismissable">
						<p>Your login attempt was not successful, try again.</p>
						<p>
							Reason:
							<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
							.
						</p>
					</div>
				</c:if>
				<form class="" action="<c:url value='/sign.spring'/>" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="user"
							placeholder="Username"> <input type="password"
							class="form-control" name="pass" placeholder="Password">
						<button type="submit" class="btn btn-default">Sign In</button>
					</div>
				</form>
			</div>
		</div>
		<div>
			<p>
				Go <a href="index.html">home</a>
			</p>
		</div>
	</div>
</body>
</html>