<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Login</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${pageContext.request.contextPath}/styles/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/scripts/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Sign-In</h3>
			</div>
			<div class="panel-body">

				<%
				  if (request.getParameter("login_error") != null
				      && !request.getParameter("login_error").isEmpty()) {
				%>

				<div class="alert alert-danger alert-dismissable">
					<p>Your login attempt was not successful, try again.</p>
					<p>Reason: ${SPRING_SECURITY_LAST_EXCEPTION.message}.</p>
				</div>
				<%
				  }
				%>

				<form action="${pageContext.request.contextPath}/secured/sign"
					method="post">
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
				Go <a href="${pageContext.request.contextPath}/index.html">home</a>
			</p>
		</div>
	</div>
</body>
</html>