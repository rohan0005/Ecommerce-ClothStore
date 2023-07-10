<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<link rel="stylesheet" type="text/css" href="css/cart.css">
</head>

<style>
.alert {
  padding: 15px;
  margin-bottom: 20px;
  border: 1px solid transparent;
  border-radius: 4px;
}

.alert-success {
  color: #155724;
  background-color: #d4edda;
  border-color: #c3e6cb;
}
</style>
</head>
<body>


<script>
  // get the success message element
  const successMessage = document.getElementById('successMessage');

  // hide the message after 3 seconds
  setTimeout(() => {
    successMessage.style.display = 'none';
  }, 3000);
</script>


<!-- Check if success message exists in session  --> 
<c:if test="${not empty sessionScope.successMessage}">
  <!-- Get success message from session  --> 
  <c:set var="successMessage" value="${sessionScope.successMessage}" />

  <!-- Display success message in HTML  --> 
  <div class="alert alert-success">${successMessage}</div>

  <!-- Remove success message from session --> 
  <%
    session.removeAttribute("successMessage");
  %>
</c:if>





	<div class="container">
		<h1>Shopping Cart</h1>
		
		<c:if test="${not empty cartItems}">
			<c:forEach var="cartItem" items="${cartItems}">
			<!--  from="${cartItems}">-->
<div class="cart-item">
<img src="http://localhost:8080/images/${cartItem.imageUrl}" alt="${cartItem.name}">
<div class="cart-item-details">
<h2>${cartItem.name}</h2>
<p>Brand: ${cartItem.brand}</p>
<p>Price: ${cartItem.price}</p>
<div class="cart-item-quantity">
<form action="CartServlet?action=update" method="post">
<input type="hidden" name="c_id" value="${cartItem.c_id}">
<input type="hidden" name="id" value="${cartItem.id}">
<input type="hidden" name="username" value="${cartItem.username}">
<input type="hidden" name="name" value="${cartItem.name}">
<input type="hidden" name="brand" value="${cartItem.brand}">
<input type="hidden" name="price" value="${cartItem.price}">
<input type="hidden" name="image" value="${cartItem.imageUrl}">
<label>Quantity:</label>
<input type="number" name="quantity" min="1" max="10" value="${cartItem.quantity}">
<button type="submit">Update</button>
</form>
<form action="CartServlet" method="post">
<input type="hidden" name="action" value="delete">
<input type="hidden" name="c_id" value="${cartItem.c_id}">
<input type="hidden" name="id" value="${cartItem.id}">
<button type="submit">Remove</button>
</form>
</div>
<div class="cart-item-total">
Total: ${cartItem.total}
</div>
</div>
</div>
</c:forEach>

		<div class="cart-total">
			<span>Total items: ${fn:length(cartItems)}</span>
			<c:set var="cartTotal" value="0" />
			<c:forEach items="${cartItems}" var="item">
			    <c:set var="cartTotal" value="${cartTotal + item.total}" />
			</c:forEach>
			<span>Cart total: $${cartTotal}</span>


			

			<form action="checkout" method="post">
				<button class="checkout-button" type="submit">Checkout</button>
			</form>
		</div>
		
		<a class="cont-shopping" href="${pageContext.request.contextPath}/FetchProductServlet">Continue Shopping</a>
	</c:if>
	
	<c:if test="${empty cartItems}">
		<p style="text-align: center;">Your cart is empty.</p>
		<a href="${pageContext.request.contextPath}/FetchProductServlet" class="checkout-button" type="submit">Continue Shopping</a>
	</c:if>
	
	
	
</div>

    </body>
</html>