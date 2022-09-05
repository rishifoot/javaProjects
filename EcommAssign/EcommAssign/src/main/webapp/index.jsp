<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="java.util.List"%>
<%@page import="com.nagarro.*"%>

  
 <%
ProductDao prodData = new ProductDao(ConnectionDao.getCon());
List<Product> product = prodData.getAllProduct();
request.setAttribute("PROD_LIST", product);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Home Page</title>
</head>
<body>
<div class="container-fluid">
		<nav class="navbar navbar-light">
			<a class="navbar-brand">Product Management Tool</a>
			<ul class="navbar-nav ml-auto mt-3 mx-5">
			<li class="nav-item">Hi Username<a href="log-out" class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</div>
	
	<div class="container mt-2">
		<div class="inner">
			<h6>Please enter product details to add to stock.</h6>
			<div class="row">
				<div class="col-md-5">
					
					<form action="AddProductServlet" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label>Product Title</label> <input type="text" class="form-control"
								name="title" required>
						</div>
						<div class="form-group">
							<label>Quantity</label> <input type="text" class="form-control"
								name="quantity" required>
						</div>
						<div class="form-group">
							<label>Size</label> <input type="text" class="form-control"
								name="size" required>
						</div>
						<div class="form-group mb-2">
							<label>Image</label> <input type="file" class="form-control"
								name="file" required>
						</div>
						
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn btn-danger">Clear</button>
					</form>
				</div>
				</div>
				<br>
				<hr>
				<p>Product Information-</p>
				<div class="row">
				<div class="col-md-12 col-sm-10 mx-auto">
					<table class="table">
						<thead class="bg-light">
							<tr>
								<th scope="col">Title</th>
								<th scope="col">Quantity</th>
								<th scope="col">Size</th>
								<th scope="col">Image</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<%-- <c:forEach var="p" items="${PROD_LIST}">    ${p.title }--%>
							<%-- for (Product pd : product) {
							
								out.println(pd.getTitle());
								out.println(pd.getQuantity());
								out.println(pd.getSize());
								out.println(pd.getImage()+ "</br>");
							
							}
							--%>
							<% for (Product pd : product) {%>
								<tr>
									<td><%=pd.getTitle() %></td>
									<td><%=pd.getQuantity() %></td>
									<td><%=pd.getSize() %></td>
									<td><img src="<%=pd.getImage() %>" width="50" height="50"></td>
									<td><a href="editproduct.jsp?id=<%=pd.getId() %>"><i class="fa fa-edit"></i></a><a
										href="DeleteProductServlet?id=<%=pd.getId() %>">delete</a></td>
								</tr>
								<% }%>
							
								
							<%-- </c:forEach>--%>
							
						</tbody>
					</table>
				</div>
				</div>
			</div>
		</div>
	</div>
	
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	 
</body>
</html>