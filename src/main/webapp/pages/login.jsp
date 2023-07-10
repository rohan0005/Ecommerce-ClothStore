<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

    		<% if(request.getAttribute("errorMessage") != null) { %>
        		<script>
    				alert("<%= request.getAttribute("errorMessage") %>");
  				</script>
    		<% } %>


  <header class="header-color">
    <a href="../index.jsp" class="luxe-logo">
      <h1>Lux<span class="looks">Looks</span></h1>
    </a>
    <p class="new-user">New User?<a href="register.html" class="register">Register</a></p>
  </header>

  <!--MAIN CONTENT-->

  <div class="login-flex">
    <img src="../image/login.png" alt="" class="login-image">
 
    <div>
    <form method="post" action="${pageContext.request.contextPath}/LoginUserServlet">
      <p class="welcome-msg">Welcome Back!</p>
      <p class="login-msg">Login to continue</p>

      <input class="input-box-username" type="text" id="username" name="username" placeholder="Username">
      <input class="input-box-pwd" type="password" id="pwd" name="pwd" placeholder="Password">
      <button class="login-btn" type="submit" id="login-btn">Login</button>
    </form>
    </div>
  </div>
</body>
</html>