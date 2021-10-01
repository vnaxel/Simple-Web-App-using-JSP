<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Create Product</h3>

<p style="color:red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/createProduct">
<label for="code">Code</label><br>
<input type="text" name="code" value="${product.code}"/>
<br>
<br>
<label for="name">Name</label><br>
<input type="text" name="name" value="${product.name}"/>
<br>
<br>
<label for="price">Price</label><br>
<input type="text" name="price" value="${product.price}"/>
<br>
<br>
<input type="submit" value="Submit"/>
<a href="productList">Cancel</a>
</form>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>