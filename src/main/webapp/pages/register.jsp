<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register</title>
	<link rel="stylesheet" type="text/css" 
		href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
	<c:if test="${not empty errorMessage}">
		<p style="color: red">${errorMessage}</p>
	</c:if>
	<form method="post" action="${pageContext.request.contextPath}/RegisterServlet" enctype="multipart/form-data">
    <header class="header-color" onscroll="myFunction()">
        <a href="../index.html" class="luxe-logo">
            <h1>Lux<span class="looks">Looks</span></h1>
        </a>
    </header>

    <div class="register-flex">
        <img src="../image/create-acc.jpg" alt="" class="register-img">
        <div>
            <h1 class="get-started">Get Started</h1>
            <div style="display: flex;">
                <div>
                    <p class="get-started-desc">First Name</p>
                    <input class="reg-text" type="text" id="firstName" name="firstName" placeholder="First Name" required>
                </div>
                <div>
                    <p class="get-started-desc">Last Name</p>
                    <input class="reg-text" type="text" id="lastName" name="lastName" placeholder="Last Name" required>
                </div>
            </div>

            <div style="display: flex;">
                <div>
                    <p class="get-started-desc">Email</p>
                    <input class="reg-text" type="email" id="email" name="email" placeholder="Email" required>
                </div>
                <div>
                    <p class="get-started-desc">Username</p>
                    <input class="reg-text" type="text" id="username" name="username" placeholder="Username" required>
                </div>
            </div>

            <div style="display: flex;">
                <div>
                    <p class="get-started-desc">Password</p>
                    <input class="reg-text" type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <div>
                    <p class="get-started-desc">Re-enter Password</p>
                    <input class="reg-text" type="password" id="password" name="password" placeholder="Password" required>
                </div>
            </div>
            
            <div><p class="get-started-desc">Upload Profile Image</p><input type="file"  accept="image/*" id="image" name="image" required></div>


            <p><input class="check-box" type="checkbox" required id="terms-condition" name="terms-condition" value="checkbox">I
                agree to the <span style="color: red;">Terms of service</span> and <span style="color:red;">Privacy
                    Policy</span></p>


            <div style="display: flex;">
                
                <button class="register-btn" type="submit" id="register-btn">Register</button>
                <p class="already-have-account">Already have account?<a href="login.jsp" class="login-redirect">Login</a>
                </p>
            </div>
        </div>





    </div>
	</form>
</body>
</html>