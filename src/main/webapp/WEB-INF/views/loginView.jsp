<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Login Page</h3>
<p style="color: red;">${errorString}</p>
<form method="POST" action="${pageContext.request.contextPath}/login">
<label for="userName">User Name</label>
<br>
<input type="text" name="userName" value="${user.userName}">
<br>
<br>
<label for="password">Password</label>
<br>
<input type="password" name="password" value="${user.password}">
<br>
<br>
<label for="rememberme">Remember me </label>
<input type="checkbox" name="rememberMe" value="Y">
<br>
<br>
<input type="submit" value="Submit">
<a href="${pageContext.request.contextPath}/">Cancel</a>
</form>
<p style="color:blue;">userNames are: "tom", "jerry". <br> passwords are: userName + "001"</p>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>