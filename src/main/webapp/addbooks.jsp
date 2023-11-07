<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">Add</h1>
	<form action="addbook" method="post" style="text-align: center;">
		<label>id</label> <input type="number" name="id"><br>
		<br> <label>name</label> <input type="text" name="name"><br>
		<br> <label>Author</label> <input type="text" name="author"><br>
		<br> <label>price</label> <input type="number" name="price"><br>
		<br> <label>Gener</label> <input type="text" name="gener"><br>
		<br> <br> <input type="submit"><br> <br>

	</form>
</body>
</html>