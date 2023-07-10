<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Products</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>

<div style="width: 200px;">
<a href="" class="luxe-logo">
  <h1>Lux<span class="looks">Looks</span></h1>
</a>
</div>

<!-- Checking if data entered or not -->

<% String resultMessage = (String) request.getAttribute("resultMessage"); %>
<% if (resultMessage != null) { %>
    <div class="alert alert-primary" role="alert">
        <%= resultMessage %>
    </div>
<% } %>

<div class="add-product-flex">
  <div>
    <form method="post" action="${pageContext.request.contextPath}/AdminUpdateProductServlet" enctype="multipart/form-data">
      <h1 class="txt-add-prod">ADD PRODUCTS</h1>
      <br>
      <div class="txt-name">
      <label>Product Id:</label>
      <input class="input-box" type="number" id="id" name="id" min="1" required><br><br>
      </div>

      <div class="txt-name">
      <label>Product Name:</label>
      <input class="input-box" type="text" id="product" name="name" required><br><br>
      </div>

      <div class="txt-name">
      <label>Brand:</label>
      <input class="input-box" type="text" id="brand" name="brand" required><br><br>
      </div>
      
      <div class="txt-name">
      <label>Price:</label>
      <input class="input-box" type="number" id="price" name="price" min="100" max="9999"><br><br>
      </div>

      <div class="txt-name">
      <label>Choose Image:</label>
      <br>
      <input type="file"  accept="image/*" id="image" name="image" required>
      </div>
      <div>
      <input class="sub-btn" type="submit" value="Submit">
      </div>

      <a class="back-href" href="${pageContext.request.contextPath}/pages/admin.jsp">Back</a>
    </form>
  </div>

  <div>
    <img class="add-prod-img" src="${pageContext.request.contextPath}/image/add-products.jpg" alt="">
  </div>
</div>
</body>
</html>