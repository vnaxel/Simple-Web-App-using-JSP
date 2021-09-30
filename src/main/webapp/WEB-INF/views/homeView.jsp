<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<div style="flex-grow: 1;">

<h3>Home Page</h3>

This is a simple web app using jsp, servlet and jdbc.
<br><br>

<p>It includes the following functions:</p>
<ul>
<li>Login</li>
<li>Storing user information in cookies</li>
<li>Product List</li>
<li>Create Product</li>
<li>Edit Product</li>
<li>Delete Product</li>
</ul>

</div>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>