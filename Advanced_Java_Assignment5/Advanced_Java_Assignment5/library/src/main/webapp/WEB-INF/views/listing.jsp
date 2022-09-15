<%@page import="com.nagarro.library.entity.Author"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.nagarro.library.entity.Book"%>
<%@page import="com.nagarro.library.utils.JsonToObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
if (request.getSession().getAttribute("username") == null) {
	System.out.println("ERROR: Cannot access product page without login");
	response.sendRedirect("./");
}
%>
<%!DateFormat dateFormate = new SimpleDateFormat("dd MMMM yyyy");%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value="/resources/css/base.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/listing.css" />" type="text/css">
<title>Books Listing</title>
</head>
<body>
	<nav class="navbar">
		<div class="nav-content">
			<span class="nav-title">Library Management System</span> <span
				class="nav-option">
				<form action="./logout" method="post">
					Welcome
					<%=session.getAttribute("username")%>
					<input type="submit" value="Logout" class="btn btn-logout">
				</form>
			</span>
		</div>
	</nav>
	<main class="main j-left">
		<header class="header">
			<span class="header-text">Books Listing</span> <input type="button"
				value="Add a book" class="btn btn-info p-right" id="addBook">
		</header>
		<table class="list-view">
			<thead>
				<tr>
					<th>Book Code</th>
					<th>Book Name</th>
					<th>Author</th>
					<th>Date Added</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Book> books = new JsonToObject().getBooks("http://localhost:8083/listbook/");
				for (Book book : books) {
				%>
				<tr>
					<td><%=book.getId()%></td>
					<td><%=book.getName()%></td>
					<td><%=book.getAuthor()%></td>
					<td><%=dateFormate.format(book.getDate())%></td>
					<td><input type="button" value="Edit"
						class="btn btn-info w-50" id="editBtn"
						data-id="<%=book.getId()%>"> <input type="button"
						value="Delete" class="btn btn-logout w-50" id="deleteBtn"
						data-id="<%=book.getId()%>"></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
	<footer class="footer">&copy; Copyright 2022 - Nagarro
		Technology</footer>
	<div class="pop-up add-form" id="addForm">
		<form action="http://localhost:8083/addbook/" method="post"
			id="addBookForm">
			<header class="header">Add Book Details</header>
			<table>
				<tbody>
					<tr>
						<td>Book Code</td>
						<td><input type="number" name="id" id="bookCode"
							class="input-field w-100" min="0" required></td>
					</tr>
					<tr>
						<td>Book Name</td>
						<td><input type="text" name="name" id="bookName"
							class="input-field w-100" required></td>
					</tr>
					<tr>
						<td>Author</td>
						<td><select name="author" id="bookAuthor"
							class="input-field w-100" required>
								<option value="" selected disabled>--Select--</option>
								<%
								List<Author> authors = new JsonToObject().getAuthors("http://localhost:8083/listauthors/");
								for (Author author : authors) {
								%>
								<option value="<%=author.getName()%>"><%=author.getName()%></option>
								<%
								}
								%>
						</select></td>
					</tr>
					<tr>
						<td>Added On</td>
						<td><%=dateFormate.format(new Date())%></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="btn btn-info"> <input type="reset" value="Cancel"
							class="btn btn-logout" id="hideAddForm"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div class="pop-up add-form" id="editForm">
		<form action="http://localhost:8083/updatebook/" method="put"
			id="editBookForm">
			<header class="header">Edit Book Details</header>
			<table>
				<tbody>
					<tr>
						<td>Book Code</td>
						<td><input type="number" value="" name="id" id="id"
							class="input-field w-100" required readonly></td>
					</tr>
					<tr>
						<td>Book Name</td>
						<td><input type="text" value="" name="name" id="name"
							class="input-field w-100" required></td>
					</tr>
					<tr>
						<td>Author</td>
						<td><select name="author" id="author"
							class="input-field w-100" required>
								<option value="" selected disabled>--Select--</option>
								<%
								for (Author author : authors) {
								%>
								<option value="<%=author.getName()%>"><%=author.getName()%></option>
								<%
								}
								%>
						</select></td>
					</tr>
					<tr>
						<td>Added On</td>
						<td><%=dateFormate.format(new Date())%></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="btn btn-info" id="submitForm"> <input type="reset"
							value="Cancel" class="btn btn-logout" id="hideEditForm">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div class="pop-up add-form" id="deleteForm">
		<form action="http://localhost:8083/deletebook/" method="delete"
			id="deleteBookForm">
			<header class="header">Delete Book</header>
			<input type="hidden" name="id" value="" id="id"
				class="input-field w-100"> <input type="submit"
				value="Delete" class="btn btn-info" id="submitForm"> <input
				type="reset" value="Cancel" class="btn btn-logout"
				id="hideDeleteForm">
		</form>
	</div>
	<script src="<c:url value="/resources/js/listing.js" />"></script>
	<script src="<c:url value="/resources/js/request.js" />"></script>
</body>
</html>