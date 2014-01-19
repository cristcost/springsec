<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Start Page</title>
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
				<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
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
			<h1>Spring Security Study</h1>
			<p>
				Examples of <b>Spring Security</b> in <b>ServiceMix</b> environment
				with some web examples that use <b>GWT</b>
			</p>
		</div>

		<h3>Intro</h3>
		<div class="row">
			<div class="col-md-12">
				<p>We will build step by step proof of concepts to test together
					all the features we want to integrate and protect with Spring
					Security.</p>
				<p>Under the hood we use Spring MVC, and actually we trust it is
					working or else you will not see neither this page.</p>
				<p>There have been defined two test user:</p>
				<div class="row">
					<div class="col-md-3">
						<div class="panel panel-primary">
							<div class="panel-heading">Regular User</div>
							<div class="panel-body">With username &quot;user&quot; and
								password &quot;123&quot;, it has the role &quot;USER_ROLE&quot;</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="panel panel-primary">
							<div class="panel-heading">Administration User</div>
							<div class="panel-body">With username &quot;admin&quot; and
								password &quot;123&quot;, it has both the role
								&quot;USER_ROLE&quot; and &quot;ADMIN_ROLE&quot;</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<h3>Login and Logout</h3>
		<div class="row">
			<div class="col-md-8">
				<p>This initial page for simplicity don't checks your
					credentials, so I don't know now if you are logged or not.</p>
				<p>Use the following links for logging in and out.</p>

			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Login and Logout</div>
					<ul class="list-group">
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/login.html">Login</a>
							page</li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/logout">Logout
								URL</a> (you are redirected to homepage after logout)</li>
					</ul>
				</div>
			</div>
		</div>

		<h3>Security Starter</h3>
		<div class="row">
			<div class="col-md-6">
				<p>We also need taglibs support. The following examples allow us
					to test if it works:</p>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Taglib</div>
					<ul class="list-group">
						<li class="list-group-item">Do taglibs are working? <a
							href="${pageContext.request.contextPath}/secured/tags.basic.html">Check
								it out</a>
						</li>
						<li class="list-group-item">And do Spring taglibs are working
							too? <a
							href="${pageContext.request.contextPath}/secured/tags.sec.html">Let's
								see</a>
						</li>
						<li class="list-group-item">And what it happen if I use
							security tags under an URL <a
							href="${pageContext.request.contextPath}/unfiltered/tags.sec.html"
							title="URL under /unfiltered/* are not processed by Spring Security filter chain">that
								is not filtered</a>? The authentication information is not available...
						</li>
					</ul>
				</div>
			</div>
		</div>

		<h3>Basic Security Examples</h3>
		<div class="row">
			<div class="col-md-4">
				<p>These examples pages require specific roles to access. If you
					are not Authenticated Spring security will prompt for login.</p>
				<p>
					If you are authenticated but you can't access the page, you need to
					<a href="${pageContext.request.contextPath}/secured/logout">logout</a>.
				</p>
				<p>The examples that follow open the same pages but without the
					Spring Security filter chain, so it happen that you could access
					these pages freely! Be careful.</p>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Basic security</div>
					<ul class="list-group">
						<li class="list-group-item">Page accessible by <a
							href="${pageContext.request.contextPath}/secured/demo.any.html">Anyone</a>
						</li>
						<li class="list-group-item">Page accessible by <a
							href="${pageContext.request.contextPath}/secured/demo.auth.html">Any
								Authenticated</a> User
						</li>
						<li class="list-group-item">Page that <a
							href="${pageContext.request.contextPath}/secured/demo.user.html">requires
								USER Role</a></li>
						<li class="list-group-item">Page that <a
							href="${pageContext.request.contextPath}/secured/demo.admin.html">requires
								ADMIN Role</a></li>
						<li class="list-group-item">Why not? Page that requires <a
							href="${pageContext.request.contextPath}/secured/demo.unauth.html">
								you are not authenticated</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Unfiltered pages!</div>
					<ul class="list-group">
						<li class="list-group-item">Page accessible by <a
							href="${pageContext.request.contextPath}/unfiltered/demo.any.html">Anyone</a>
						</li>
						<li class="list-group-item">Page accessible by <a
							href="${pageContext.request.contextPath}/unfiltered/demo.auth.html">Any
								Authenticated</a> User
						</li>
						<li class="list-group-item">Page that <a
							href="${pageContext.request.contextPath}/unfiltered/demo.user.html">requires
								USER Role</a></li>
						<li class="list-group-item">Page that <a
							href="${pageContext.request.contextPath}/unfiltered/demo.admin.html">requires
								ADMIN Role</a></li>
						<li class="list-group-item">Why not? Page that requires <a
							href="${pageContext.request.contextPath}/unfiltered/demo.unauth.html">
								you are not authenticated</a></li>
					</ul>
				</div>
			</div>
		</div>

		<h3>Web Frameworks</h3>
		<div class="row">
			<div class="col-md-6">
				<p>Let's try now to combine some basic web framework.</p>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Web Frameworks</div>
					<ul class="list-group">
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/web.jquery.html">jQuery</a>
						</li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/web.gwt.html">GWT</a>
						</li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/web.angular.html">AngularJS</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<h3>Servlets</h3>
		<div class="row">
			<div class="col-md-8">
				<p>Spring provides the interface HttpRequestHandler for
					implementing servlet like handling of requests which support
					injection.</p>
				<p>But GWT RPC services are HttpServlet, so we need servlet
					support. And also we don't want our application to depend so much
					on Spring. It is not well documented, but we can deploy Servlets
					under Spring MVC, and we can also inject beans in them.</p>
				<p>And more important, we can apply Spring Security to both
					HttpRequestHandler and HttpServlet when used with Spring MVC.</p>
				<p>The following examples show both a HttpRequestHandler and
					HttpServlet that apply Spring Security to beans. Authentication is
					coming from the Spring Security filter chain.</p>
				<p>What it happens outside of the filter chain? You get no
					authentication, see the examples that follows</p>
				<p>In such case you need ad different authentication method. The
					example code implements a simple manual authentication mechanism
					which authenticate the user with query string parameters (don't do
					that at home!). The last links show what it happen outside of the
					Spring Scurity filter chain with this authentication mechanism</p>
			</div>


			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Servlets</div>
					<ul class="list-group">
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/http-request-handler.servlet">Spring's
								HttpRequestHandler</a></li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/standard.servlet">Standard
								Servlet</a></li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/unfiltered/http-request-handler.servlet">Unfiltered
								HttpRequestHandler</a></li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/unfiltered/standard.servlet">Unfiltered
								Standard Servlet</a></li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/unfiltered/http-request-handler.servlet?user=admin&amp;pass=123">Unfiltered
								HttpRequestHandler</a> with parameters for manual authentication</li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/unfiltered/standard.servlet?user=admin&amp;pass=123">Unfiltered
								Standard Servlet</a> with parameters for manual authentication</li>

					</ul>
				</div>
			</div>
		</div>

		<h3>Secured GWT application</h3>
		<div class="row">
			<div class="col-md-6">
				<p>Let's now see an example of a secured GWT web application.</p>
				<p>It combines concepts built up to now.</p>
				<p>The GWT application use spring security only for profiling
					the interface, but the JavaScript application is always fully
					downloaed and an hacker could override and execute unwanted code.
					So we need to focus the protection layer on the GWT RPC service.
					The examples that follow shows what it happen when someone hacks
					the page and Security on the service bean is used.</p>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">GWT and Spring Security</div>
					<ul class="list-group">
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/gwt.secured.html">Secured
								GWT Application</a></li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/secured/gwt.hacked.html">Hacked
								GWT Application</a></li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/unfiltered/gwt.secured.html">
								GWT Application</a> out of Spring Security filter chain</li>
						<li class="list-group-item"><a
							href="${pageContext.request.contextPath}/unfiltered/gwt.hacked.html">Hacked
								GWT Application</a> out of Spring Security filter chain</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>