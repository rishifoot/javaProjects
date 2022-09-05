<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.nagarro.*"%>
<%@ page import="java.util.*"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	response.sendRedirect("index.jsp");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Login Page</h1>

	<div class="container">

		<div class="row mt-4 d-flex">
			<div class="col-sm-8  mx-auto">
				<div class="card">

					<h5 class="card-header">Login</h5>
					<a href="index.jsp" class="btn">Home Page</a>


					<div class="card-body text-end">
						<form action="/EcommJSP/user-login" method="post">
							<div class="row mb-3">
								<div class="col-3 col-md-4 text-start">
									<label for="" class="form-label">Email</label>
								</div>
								<div class="col-9 col-md-6 text-center control-label">
									<input type="text"
										class="form-input m-0 w-100 rounded border-1" name="email"
										required />
								</div>
							</div>
							<div class="row mb-3">
								<div class="col-3 col-md-4 text-start">
									<label for="" class="form-label">Password</label>
								</div>
								<div class="col-9 col-md-6 text-center control-label">
									<input type="password"
										class="form-input m-0 w-100 rounded border-1" name="password"
										required />
								</div>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Login
								>></button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>