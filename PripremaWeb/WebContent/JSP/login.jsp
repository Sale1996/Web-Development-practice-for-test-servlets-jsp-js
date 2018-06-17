<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="error" class="java.lang.String" scope="request"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Prijava</h2>
	<form action="LoginServlet" method="post">
	<table>
		<tr>
			<td>Korisnicko ime</td>
			<td><input type="text" name="txt_usename" 	></td>
		</tr>
		<tr>
			<td>Lozinka</td>
			<td><input type="password" name="txt_password"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" name="btn_login" value="Prijava"></td>
		</tr>
	</table>
	</form>
	<% if(!error.equals("")) %>
		<p style="color: red" > <%= error %> </p>
		
		

</body>
</html>