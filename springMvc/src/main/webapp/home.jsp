<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="search" method="POST">
		<table>
			<tr>
				<td>Colour :</td>
				<td><input type="text" name="colour" required /></td>
			</tr>
			<tr>
				<td>Size :</td>
				<td><input type="text" name="size" required /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><select name="gender_recommendation" required>
						<option value="M">Male</option>
						<option value="F">Female</option>
						<option value="U">Unisex</option>
				</select></td>
			</tr>
			<tr>
				<td>Sort by :</td>
				<td><select name="sortingType" required>
						<option selected value="price">Price</option>
						<option value="rating">Rating</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>

</body>
</html>