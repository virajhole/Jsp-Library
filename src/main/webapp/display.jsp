
<%@page import="jsp_library.Book"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success page</title>
</head>
<body style="text-align: center;">
	<h1>Login Successfully</h1>
	<%
	List<Book> list = (List) request.getAttribute("booksList");
	%>
	<center>
		<table border="2px solid"style:text-aling:center">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Author</th>
				<th>Price</th>
				<th>Gener</th>

			</tr>

			<%
			for (Book book : list) {
			%>
			<tr>

				<td><%=book.getId()%></td>
				<td><%=book.getName()%></td>
				<td><%=book.getAuthor()%></td>
				<td><%=book.getPrice()%></td>
				<td><%=book.getGener()%></td>

				<td><a href="delete?id=<%=book.getId()%>"><button>Delete</button></a>
				</td>
				<td><a href="update?id=<%=book.getId()%>"><button>Update</button></a>
				</td>

			</tr>

			<%
			}
			%>
			
		</table>
			<br> <br> <a href="addbooks.jsp"><button>Add Book</button></a>
		<br> <br> <a href="login.jsp"><button>LOG OUT</button></a>
	</center>
</body>
</html>