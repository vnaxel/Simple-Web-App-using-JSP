<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Edit Product</h3>

<p style="color:red;">${errorString}</p>

<c:if test="${not empty product}">
<form method="POST" action="${pageContext.request.contextPath}/editProduct">
<input type="hidden" name="code" value="${product.code}"/>
<p style="color:red;">${product.code}</p>
<label for="name">Name</label><br>
<input type="text" name="name" value="${product.name}"/>
<br>
<br>
<label for="price">Price</label><br>
<input type="text" name="price" value="${product.price}"/>
<br>
<br>
<input type="submit" value="Submit"/>
<a href="${pageContext.request.contextPath}/productList">Cancel</a>
</form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>