<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<%
	String message = (String) request.getAttribute("message");
	%>
	<%
	if (message != null) {
	%>
	<h2>
		<%=message%></h2>
	<%
	}
	%>
	<h1>Login</h1>
	<form action="loginp" method="post" style="text-align: center;">

		<label>email</label> <input type="text" name="email"><br>
		<br> <label>password</label> <input type="text" name="password"><br>
		<br> <input type="submit"><br> <br>
		<%
		String failed = (String) request.getAttribute("failed");
		%>
		<%
		if (failed != null) {
		%>
		<h2><%=failed%></h2>
		<%
		}
		%>
	</form>
</body>
</html>