<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Admin</title>
<link rel="stylesheet" type="text/css" 
		href="${pageContext.request.contextPath}/css/admin.css"/>
		<link rel="stylesheet" type="text/css" 
		href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<style>
.view-prod
{
margin-top: 9px; 

color: white;
background-color: #46DB00;
}


.view-btn
{

color: white;


}


</style>



<body>

<div>
  <div class="admin-flex">
    <a href="" class="luxe-logo">
      <h1>Lux<span class="looks">Looks</span></h1>
    </a>

    
      <form method="post" action="${pageContext.request.contextPath}/LogoutServlet" enctype="multipart/form-data">
      	<button class="logout-admin" type="submit" id="logout-btn"><h1 class="logout-text">Logout</h1></button>
      </form>
    
  </div>

  <div class="welcome-admin">
    <h1 style="margin-top: 20px;">Welcome <span style="color: #e90505; font-size: 50px;">Admin</span></h1>
  </div>

  <div class="admin-work">

    <div class="manage-flex-admin">
      <img class="manage-admin-img" src="../../image/orders.jpg" alt="img">
      
      <a style="color: #ffffff" href=""><h2 style="margin-top: 9px; text-decoration: none">View Orders</h2></a>

    </div>

    <div class="manage-flex-admin">
      <img class="manage-admin-img" src="../../image/add.jpg" alt="img">
      
      <a href="addProduct.jsp" style="color: #ffffff"><h2 style="margin-top: 9px; text-decoration: none">Add Product</h2></a>

    </div>

    <div class="manage-flex-admin">
      <img class="manage-admin-img" src="../../image/view.jpg" alt="img">
      <form method="post" action="${pageContext.request.contextPath}/FetchProductServlet">
      	<a href="${pageContext.request.contextPath}/FetchProductServlet" class="view-btn" id="btn">
        <h2 class="view-prod">View Products</h2>
    </a>
	  </form>
    </div>

    <div class="manage-flex-admin">
      <img class="manage-admin-img" src="../../image/update.jpg" alt="img">   
      <!--  <form method="post" action="${pageContext.request.contextPath}/FetchProductServlet?action=update"> -->
      <a href="${pageContext.request.contextPath}/FetchProductServlet?action=update" style="color: #ffffff"><h2 style="margin-top: 9px; text-decoration: none">Update Products</h2></a>
	
    </div>

  </div>






</div>


</body>
</html>