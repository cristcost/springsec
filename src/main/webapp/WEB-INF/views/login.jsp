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
				<li class="active"><a
					href="${pageContext.request.contextPath}/secured/login.html">Login</a>
				</li>
				<li><a href="${pageContext.request.contextPath}/secured/logout">Logout
				</a></li>
			</ul>
		</div>
	</div>


	<div class="container">

		<div class="row">
			<div class="col-md-4 col-md-offset-4">
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
			</div>
		</div>

		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<p>
					Go <a href="${pageContext.request.contextPath}/index.html">home</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>