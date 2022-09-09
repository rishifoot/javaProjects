<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="LoginCheck">
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">Username</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="username" id="userid"
					placeholder="Enter your username" /> <span class="error"><p
						id="user_error" style="color: red;">&nbsp;</p></span>
			</div>
		</div>
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="password"
					id="passwordid" placeholder="Enter your password" /> <span
					class="error"><p id="pass_error" style="color: red;">&nbsp;</p></span>
			</div>
		</div>
		<input type="submit" value="Login" class="btn btn-primary">
	</form>
</body>
</html>