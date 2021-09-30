<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="background:#E0E0E0; height: 6rem; padding: 0.5rem; display: flex;">
<div>
<h1>Simple app</h1>
</div>
<div style="flex-grow: 1;"></div>
<div style="padding: 1rem; text-align: center;">
Hello ${loginedUser.userName}
<br>
Search <input name="search">
</div>
</div>