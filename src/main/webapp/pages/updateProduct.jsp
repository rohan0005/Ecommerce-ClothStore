<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Update Product</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
			background-color: #f2f2f2;
		}
		
		.container {
			max-width: 458px;
			margin: 0 auto;
			padding: 50px;
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
			animation: fadeInDown 0.5s ease;
		}
		
		h1 {
			font-size: 2rem;
			font-weight: bold;
			text-align: center;
			margin-bottom: 50px;
		}
		
		form {
			display: flex;
			flex-wrap: wrap;
			align-items: center;
			justify-content: center;
			margin-bottom: 20px;
		}
		
		form input, form select {
			width: 100%;
			padding: 10px;
			margin-bottom: 20px;
			border-radius: 5px;
			border: none;
			background-color: #f2f2f2;
			box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
		}
		
		form input[type="submit"] {
			width: auto;
			padding: 10px 20px;
			background-color: #4CAF50;
			color: #fff;
			font-size: 1rem;
			font-weight: bold;
			border-radius: 5px;
			border: none;
			cursor: pointer;
			transition: background-color 0.2s ease;
		}




    .luxe-logo h1 {
  max-width: 120px;
  height: auto;
  color: rgb(250, 12, 0);
  font-family: 'Lucida Calligraphy Italic';
  font-size: 35px;

}




.looks {
  max-width: 120px;
  height: auto;
  color: #36c000;
  height: auto;
  font-family: 'Gabriola';

}



    .back
    {
      font-size: 20px;
      color: #e56216;
    }
		
		form input[type="submit"]:hover {
			background-color: #3e8e41;
		}
		
		@media screen and (max-width: 768px) {
			.container {
				padding: 20px;
			}
			
			form input, form select {
				width: calc(50% - 10px);
			}
		}
		
		@media screen and (max-width: 568px) {
			h1 {
				font-size: 1.5rem;
			}
			
			form input, form select {
				width: 100%;
			}
		}
		
		@keyframes fadeInDown {
			from {
				transform: translateY(-50px);
				opacity: 0;
			}
			
			to {
				transform: translateY(0);
				opacity: 1;
			}
		}
	</style>
</head>
<body>
</div>
  <a style="  text-decoration: none; width: 100px;" href="index.jsp" class="luxe-logo">
    <h1>Lux<span class="looks">Looks</span></h1>
  </a>
</div>
	<div class="container">
		<h1>Update Product</h1>
		<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/UpdateProductServlet">
			<input type="hidden" name="id" value="${product.id}">
			<label for="name">Name:</label>
			<input type="text" id="name" placeholder="${product.name}" name="name" value="${product.name}">
			
      <label for="name">Category</label>
    <select>
      <option value="Nike" ${product.brand == 'NIKE' ? 'selected' : ''}>NIKE</option>
			<option value="Adidas" ${product.brand == 'ADIDAS' ? 'selected' : ''}>ADIDAS</option>
			<option value="Puma" ${product.brand == 'VANS' ? 'selected' : ''}>VANS</option>
		</select>
		<label for="price">Price:</label>
		<input min="100" type="number" id="price" placeholder="${product.price
		}" name="price" value="${product.price}" required>
		<label for="image">Image:</label>
		<input type="file" id="image" name="image" accept="image/*">
		<input type="submit" value="Update Product">
	</form>
  <a class="back" href="updateProduct.jsp">Back</a>
</div>
</body>
</html>