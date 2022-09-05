<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.nagarro.*"%>
<%@page import="com.nagarro.ProductDao"%>
<%@page import="com.nagarro.ConnectionDao"%>


<%
int id = Integer.parseInt(request.getParameter("id"));
ProductDao prod = new ProductDao(ConnectionDao.getCon());
Product product = prod.getSingleProduct(id);
request.setAttribute("edit_product", product);
%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">


<meta charset="ISO-8859-1">
<title>Edit Product Data</title>
</head>
<body>
<div class="container-fluid">
		<nav class="navbar navbar-light">
			<a class="navbar-brand">Product Store</a>
			<ul class="navbar-nav ml-auto mt-3 mx-5">
				<li class="nav-item"><a class="nav-link active"
					href="index.jsp">Home</a></li>
			</ul>
		</nav>
	</div>
	<div class="inner">
		<div class=" container">
			<div class="row mb-4" >
				<div class="col-12">
					<h3>Edit Product Details</h3>
					<form action="EditProductServlet" method="get" enctype="multipart/form-data">
						<div class="form-group">
							<label>Product ID</label> <input class="form-control" name="id"
								value="${edit_product.id }" required readonly>
						</div>
						<div class="form-group">
							<label>Title</label> <input type="text" class="form-control"
								name="title" value="${edit_product.title }" required>
						</div>
						<div class="form-group">
							<label>Quantity</label> <input type="text" class="form-control"
								name="quantity" value="${edit_product.quantity}" required>
						</div>
						<div class="form-group">
							<label>Size</label> <input type="text" class="form-control"
								name="size" value="${edit_product.size}" required>
						</div>
						
						<div class="form-group">
							<label>Image</label> <input type="file" class="form-control"
								name="image" value="${edit_product.image}" required>
						</div>
						
						<button type="submit" class="btn btn-primary">Submit</button>
						
							<a class="btn btn btn-danger" href="index.jsp">Back</a>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>