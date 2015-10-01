<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.vz.letustry.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body><font color="#6251A6" font-weight=" bold">
		<table bgcolor="#EOECFF" width="100%">
			<tr height="2">
			<tr>
				<td style="width: 200px"></td>

				<%
					String role = (String) session.getAttribute("role");
					if (role.equals("adm")) {
				%>
				<td><a href="AdminHome.jsp">Home</a></td>
				<%
					}
				%>

				<td>Welcome <%=(String) session.getAttribute("vzId")%></td>
				<td><a href="logout.jsp">Logout</a></td>
			</tr>

		</table>
	</font>
	<br><br><br>
	<center><h2>You option is saved successfully...</h2></center>
</body>
</html>