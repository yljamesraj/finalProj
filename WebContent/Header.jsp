<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="thirdParty/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="thirdParty/js/jquery-1.11.3.js"></script>
<link rel="stylesheet" type="text/css" href="thirdParty/css/easyui.css">
<link rel="stylesheet" type="text/css" href="thirdParty/css/icon.css">

<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">

</script>

<title>Logo</title>
</head>
<body>
<table bgcolor ="#EoECFF"  width="100%">
<tr height="69">
<td><center><font size="500px" color="#6251A6">VZ SNACKS </font></center></td></tr></table>
<br>
<font color="#6251A6" font-weight=" bold">
<table bgcolor="#EOECFF" width="100%" >
<tr height="2">
<tr>
<td style="width:200px"></td>
<td>Welcome <%=(String)session.getAttribute("vzId") %></td>
<td><a href="logout.jsp">Logout</a></td></tr>



</table>
	</font>
</body>
</html>