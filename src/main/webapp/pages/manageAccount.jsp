<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
	<title>Account Settings</title>
	<style>
		body {
			background-color: #F2E6FF;
			font-family: Arial, sans-serif;
		}

		.container {
			margin: auto;
			max-width: 800px;
			padding: 20px;
			background-color: #f2f2f2;
			border-radius: 10px;
			box-shadow: 0px 0px 10px #888888;
		}

		.heading {
			font-size: 24px;
			margin-bottom: 20px;
		}

		.form-group {
			margin-bottom: 20px;
		}

		label {
			display: block;
			margin-bottom: 5px;
			font-weight: bold;
		}

		input[type="text"],
		input[type="email"],
		input[type="password"] {
			display: block;
			width: 100%;
			padding: 10px;
			border: none;
			border-radius: 5px;
			box-shadow: inset 0px 0px 5px #888888;
			background-color: #f5f5f5;
			margin-bottom: 5px;
			font-size: 16px;
			color: #333;
		}

		input[type="submit"] {
			background-color: #007bff;
			color: white;
			border: none;
			border-radius: 5px;
			padding: 10px 20px;
			font-size: 16px;
			cursor: pointer;
		}

		input[type="submit"]:hover {
			background-color: #0062cc;
		}
		.back-button
		{
			font-size: 20px;
		}
		
		.back-button:hover
		{
			color: red;
		}
		
		.alert {
		  padding: 15px;
		  margin-bottom: 20px;
		  border: 1px solid transparent;
		  border-radius: 4px;
		}
		
		.alert-success {
		  color: #3c763d;
		  background-color: #dff0d8;
		  border-color: #d6e9c6;
		}
		
	</style>
</head>
<body>
	<div class="container">
		<% String message = (String) request.getAttribute("message"); %>
		<% if (message != null && !message.isEmpty()) { %>
			<div class="alert alert-success"><%= message %></div>
			<% request.removeAttribute("message"); %>
		<% } %>
		
		<h1 class="heading">Account Settings</h1>
		<form action="${pageContext.request.contextPath}/ManageAccountServlet" method="post">
			<div class="form-group">
				<label for="first-name">First Name:</label>
				<input type="text" name="first_name" id="first_name" placeholder="Enter your first name">
			</div>

			<div class="form-group">
				<label for="last-name">Last Name:</label>
				<input type="text" name="last_name" id="last_name" placeholder="Enter your last name">
			</div>

			<div class="form-group">
				<label for="email">Email:</label>
				<input type="email" name="email" id="email" placeholder="Enter your email address">
			</div>

			<div class="form-group">
				<label for="new-password">New Password:</label>
				<input type="password" name="new_password" id="new_password" placeholder="Enter a new password">
			</div>

			<div class="form-group">
				<input type="submit" value="Save Changes">
			</div>
		</form>
		<a href="${pageContext.request.contextPath}/FetchProductServlet" class="back-button">&larr; Go Back</a>
	</div>
</body>
</html>