<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="css/style.css"/>
<link rel="stylesheet" href="css/manageAcc.css"/>
<link rel="stylesheet" href="css/homePage.css"/>
</head>
<body class="home-page">
  <div class="top-nav">
    <p>FREE SHIPPING ON ALL U.S ORDERS OVER $50</p>
  </div>

  <header class="header-color">
    <a href="index.jsp" class="luxe-logo">
      <h1>Lux<span class="looks">Looks</span></h1>
    </a>
    <ul class="navmenu">
    
      <li class="nav-hover"><a href="index.jsp" style="color: red;">Home</a></li>
      
      
      <li class="nav-hover">
      
      	<form method="post" action="${pageContext.request.contextPath}/FetchProductServlet">
    	<button class="product-click"  id="butto">Product</button>
		</form>
      	
	  </li>
      
      <!-- <li class="nav-hover"><a href="pages/contact.html">Contact</a></li> -->
    </ul>

    <ul class="nav-icons">
      
      
        <div class="dropdown">
  
		    <% if (session.getAttribute("username") == null) { %>
		    	<!--Account-->
			  <span><a href="#" class="nav-icons"><img src="image/user.png" alt="" /></a></span>
			  <div class="dropdown-content-log-reg">
		      <h4><a href="pages/login.jsp" class="dropdown-link-login">Login</a></h4>
		      <br />
		      <h4><a href="pages/register.jsp" class="dropdown-link-register">Register</a></h4>
		    <% } else { %>
		      <!--Account-->
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
		    
		          
		          <%
		          	Cookie[] cookies = request.getCookies();
		          
		          	for(Cookie c: cookies){
		          		if(c.getName().equals("username")){
		          			out.println(c.getValue());
		          		}
		          	}
		          %>
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
		      </div>
		    <% } %>
  </div>

    </ul>
  </header>

  <!--IMAGE TEXT-->
  <div class="big-img">
    <div class="texts">
      <h1>let's explore unique clothes</h1>
      <div class="button-shop">
        <button style="font-size: 15px;" id="button-shop-now">Shop Now
          <img src="image/right.png" alt="">
        </button>
      </div>
    </div>
    <img src="${pageContext.request.contextPath}/image/happy2.jpg" alt="" class="big-img-adj" />
  </div>

  <!--kfefkmefme-->
  <h1 class="new-arrivals">New Arrivals </h1>
  <div class="flex-box">

    <div class="new-arrivals">
      <div class="galary">
        <a href="#"><img class="new-arrivals-size" src="image/puma1.png" alt="" /></a>
        <div>
          <p class="collection">Adidas Collection</p>
        </div>
      </div>
    </div>

    <div class="new-arrivals">
      <div class="galary">
        <a href="#"><img class="new-arrivals-size" src="image/vans1.png" alt="" /></a>
        <div>
          <p class="collection">Vans Collection</p>
        </div>
      </div>
    </div>

    <div class="new-arrivals">
      <div class="galary">
        <a href="#"><img class="new-arrivals-size" src="image/nike.jpg" alt="" /></a>
        <div>
          <p class="collection">
            Nike Collection</p>
        </div>
      </div>
    </div>
  </div>

  <!--
      part3
    -->
  <div class="discount-div">
    <div>
      <div class="discount-image-text-container">
      </div>
      <p class="discount-image-text-payday">PAYDAY</p>
      <p class="discount-image-text-Sale">SALE NOW</p>
      <p class="discount-image-text-1">Spend minimal $100 get 30% off voucher code for your next purchase</p>
      <p class="discount-image-text-2">1 May - 10 May 2023</p>
      <p class="discount-image-text-3">*Terms & Conditions apply
        <a href="pages/product.jsp"> <button class="payday-button" id="button-subscribe">Shop Now</button> </p></a>
      <img class="discount-div-img-adj" src="image/happy4.jpg">
    </div>
  </div>
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
          <a href="contact.html">Contact us</a>
        </div>
      </div>
    </div>
    <p class="copyright">
      Copyright &copy; LuxLooks, All rights reserved 2023
    </p>
  </section>
</body>
</html>