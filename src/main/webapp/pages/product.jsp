<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/manageAcc.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/homePage.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>


<style>

#btnn:hover {
	cursor: pointer;
}


/*Search*/
  .search-form {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 43px;
  margin-left: 814px;
}

.form-group {
  margin-right: 10px;
}

.form-control {
  width: 200px;
  height: 40px;
  border-radius: 4px;
  border: none;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
  padding: 8px 12px;
}

select.form-control {
  width: 120px;
}

.btn {
  height: 40px;
  border-radius: 4px;
  border: none;
  background-color: #007bff;
  color: #fff;
  padding: 8px 12px;
  cursor: pointer;
}

.btn:hover {
  background-color: #0062cc;
}
</style>



<body>


<!--If Admin-->
<% if(session.getAttribute("userAdmin") != null){ %>


							
<div style="display: flex">
<div style="width: 170px;">
    <a href="index.jsp" class="luxe-logo">
      <h1>Lux<span class="looks">Looks</span></h1>
    </a>
</div>
    <a class="back-admin-page" href="pages/admin/admin.jsp">Back</a>
</div>

<% }

//!--If USER
else if  (session.getAttribute("userAdmin") == null){%>


<%
if (session.getAttribute("errMsg") != null) {
%>
    <script>
        alert("<%= session.getAttribute("errMsg") %>");
    </script>
<%
    session.removeAttribute("errMsg");
}
%>


<% 
   String message = (String)request.getAttribute("delMessage");
   if(message != null){
%>
  <script>
        alert("<%= session.getAttribute("delMessage") %>");
    </script>
<%
    session.removeAttribute("delMessage");
}
%>






			
<%
if (session.getAttribute("successMessage") != null) {
%>
    <script>
        alert("<%= session.getAttribute("successMessage") %>");
    </script>
<%
    session.removeAttribute("successMessage");
}
%>

		  <div class="top-nav">
		    <p>FREE SHIPPING ON ALL U.S ORDERS OVER $50</p>
		  </div>
		
		  <header class="header-color">
		    <a href="index.jsp" class="luxe-logo">
		      <h1>Lux<span class="looks">Looks</span></h1>
		    </a>
		    <ul class="navmenu">
		    
		      <li class="nav-hover"><a href="index.jsp">Home</a></li>
		      
		      <li class="nav-hover">
		      
		      	<form method="post" action="${pageContext.request.contextPath}/FetchProductServlet">
		    	<button style="color: red;" class="product-click"  id="butto">Product</button>
				</form>
		      	
			  </li>
		      
		      <!-- <li class="nav-hover"><a href="pages/contact.html">Contact</a></li> -->
		    </ul>
		    
		    
			<div style="display:flex; flex-direction: row; margin-right: -41.5px">
		    
		    <div>
		    
		    </div>
		    	
		    <div class="dropdown">
		<% if (session.getAttribute("username") == null) { %>
		    	<!--Account-->
			  <span><a href="#" class="nav-icons"><img src="image/user.png" alt="" /></a></span>
			  <div class="dropdown-content-log-reg">
		      <h4><a href="pages/login.jsp" class="dropdown-link-login">Login</a></h4>
		      <br />
		      <h4><a href="pages/register.jsp" class="dropdown-link-register">Register</a></h4>
		    </div>
		    
		    <% } else { %>
		      <!--Account Dropdown-->
		        <span><a href="#" class="nav-icons"><img src="image/user.png" alt="" /></a></span>
		        <div class="dropdown-content">
		          <div class="dropdown-link-div">
		          		 <img src="http://localhost:8080/images/<%
		          		Cookie[] cookiesimg = request.getCookies();
		          
		          		for(Cookie c: cookiesimg){
		          			if(c.getName().equals("image")){
		          				out.println(c.getValue());
		          			}
		          		}
		          		%>" alt="" class="dropdown-link-img">
		          </div>
		          <br>
		          <h1 class="user-name">
		          	${cookie['username'].value}
		          </h1>
		          <hr>
		        <div class="dropdown-link-mng-lgo">
		          <h4 style= "margin-bottom: 20px;"><a href="pages/manageAccount.jsp" class="mng-log-col">Manage Account</a></h4>
		
		          <div class="dropdown-link-logout">
		          	<form method="post" action="${pageContext.request.contextPath}/LogoutServlet">
		            <button id="butto" class="logout-btnn"><h4>Logout</h4></button> 
		            </form>
		          </div>
		        </div>
		        </div>
		        
		        <!--Add to cart-->
	
		    </div>
		      </div>
		      
		       <div style="margin-left: -246px">
		      <form method="get" action="${pageContext.request.contextPath}/CartServlet">
		      <button style="background-color: transparent; color: white; border: none;" class="button-dec" id="btnn"><img src="image/shopping-cart.png" alt=""/></button>
		    </form>
		    <% } %>
		    
		    

		    </div>
		    
		      
		  </header>
  <% } %>


<div style="display: flex; flex-wrap: nowrap;">
    <div><h1 class="all-prod">All Products</h1></div>
   	<div>
   		

	<form class="search-form" action="${pageContext.request.contextPath}/FetchProductServlet" method="get">
	  <div class="form-group">
	    <input type="text" required class="form-control" name="query" placeholder="Search for products...">
	  </div>
	  <div class="form-group">
	    <select class="form-control" name="category">
	      <option value="price">Price</option>
	      <option value="brand">Brand</option>
	    </select>
	  </div>
	
	  <button type="submit" class="btn btn-primary">Search</button>
	</form>
   		
   	</div>
     
</div>

<div class="product-grid">
  <c:forEach var="product" items="${productList}">
    <div class="product-card">
      <img class="cart-img" src="http://localhost:8080/images/${product.imageUrl}" alt="${product.imageUrl}">
      <div class="product-details">
        <h2>${product.name}</h2>
        <p>${product.brand}</p>
        <p>$${product.price}</p>
        
        
        <% if(session.getAttribute("userAdmin") != null){ %>
        
        
        	     <%
				    String action = request.getParameter("action");
				    if (action != null && action.equals("update")) {
				%>
				    <form method="post" action="${pageContext.request.contextPath}/pages/updateProduct.jsp">
				        <input type="hidden" name="id" value="${product.id}">
				        <input type="hidden" name="id" value="${product.name}">
				          <input type="hidden" name="id" value="${product.brand}">
				           <input type="hidden" name="id" value="${product.price}">
				           <input type="hidden" name="id" value="${product.imageUrl}">
				        <button class="btn-add-del" id="butoo">Update Product</button>
				    </form>
				<%
				} else{
				%>
				    <form method="post" action="${pageContext.request.contextPath}/DeleteProductServlet">
				        <input type="hidden" name="id" value="${product.id}">
				         
				        <button class="btn-add-del" id="butoo">Delete Product</button>
				    </form>
				<%
				}
				%>
		        
		<% } else{ %>
		
				<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/CartServlet?action=add">
				<input type="hidden" name="id"  value="${product.id}">
	            <button class="btn-add-del" id="butoo">Add To Cart</button>
	        	</form>
		  <% } %>
        
        
      </div>
    </div>
  </c:forEach>
</div>

<% if(session.getAttribute("userAdmin") == "admin"){ %>


<% } 

else { %>

		<!--FOOTER-->
  <section class="footer-section-wrapper">
    <div class="wrapper-footer">
      <div class="about-website">
        <a href="index.html" class="luxe-logo">
          <h1>Lux<span class="looks">Looks</span></h1>
        </a>
        <p>
          The customer is at the heart of our unique business model.
        </p>
        <div class="payment-method"></div>
      </div>
      <div class="shopping-section">
        <h3>Shopping</h3>
        <a href="#">Nike</a>
        <a href="#">Vans</a>
        <a href="#">Puma</a>
      </div>
      <div class="quick-links-section">
        <h3>Quick Links</h3>
        <a href="#">Contact us</a>
        <a href="#">Products</a>
      </div>
      <div class="newsletter-section">
        <h3>Newsletter</h3>
        <p>
         	Give up reating and feetback!
        </p>
          <!-- <a href="contact.html">Contact us</a> -->
        </div>
      </div>
    </div>
    <p class="copyright">
      Copyright &copy; LuxLooks, All rights reserved 2023
    </p>
  </section>

  <% } %>
 
  
  
  
</body>
</html>