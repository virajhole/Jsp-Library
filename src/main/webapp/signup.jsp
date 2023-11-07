<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;">Sign up</h1>
	<form action="signup" method="post" style="text-align: center;">
		<label>id</label> <input type="number" name="id"><br> <br>
		<label>name</label> <input type="text" name="name"><br> <br>
		<label>phone</label> <input type="number" name="phone"><br>
		<br> <label>address</label> <input type="text" name="address"><br>
		<br> <label>email</label> <input type="text" name="email"><br>
		<br> <label>password</label> <input type="text" name="password"><br>
		<br> <input type="submit"><br> <br>
	</form>
</body>
</html>