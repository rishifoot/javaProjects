<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="container">

		<div id="content">
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Colour</th>
					<th>Gender</th>
					<th>Size</th>
					<th>Price</th>
					<th>Rating</th>
					
				</tr>

				<c:forEach var="tshirts" items="${tshirts}">

					<tr>
						<td><c:out value="${tshirts.getId()}"></c:out></td>
						<td><c:out value="${tshirts.getName()}"></c:out></td>
						<td><c:out value="${tshirts.getColor()}"></c:out></td>
						<td><c:out value="${tshirts.getGender()}"></c:out></td>
						<td><c:out value="${tshirts.getSize()}"></c:out></td>
						<td><c:out value="${tshirts.getPrice()}"></c:out></td>
						<td><c:out value="${tshirts.getRating()}"></c:out></td>
						
					</tr>

				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>