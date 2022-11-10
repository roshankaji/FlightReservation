<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="userLogin" method="post">
	username<input type="text" name="emailid">
	password<input type="password" name="password">
	<input type="submit" value="Login">
	</form>
	${msg}
</body>
</html>