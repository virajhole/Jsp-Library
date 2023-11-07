<%@page import="jsp_library.Book"%>
 

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>
	<%
	Book book = (Book) request.getAttribute("books");
	%>
	<h1 style="text-align: center;">Update</h1>
	<form action="editp" method="post" style="text-align: center;">
		<label>id</label> <input type="hidden" name="id"
			value="<%=book.getId()%>" readonly="readonly"><br> <br>
		<label>name</label> <input type="text" name="name"
			value="<%=book.getName()%>"><br> <br> <label>Author</label>
		<input type="text" name="author" value="<%=book.getAuthor()%>"><br>
		<br> <label>price</label> <input type="number" name="price"
			value="<%=book.getPrice()%>"><br> <br> <label>Gener</label>
		<input type="text" name="gener" value="<%=book.getGener()%>"><br>
		<br> <br> <input type="submit"><br> <br>

	</form>
</body>
</html>