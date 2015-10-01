<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<script type="text/javascript">
	
</script>
</head>
<body>
<%@include file="Header.jsp" %>
<br><br><br><br>
	<center>
		<div style="margin: 10px 0;">
			<div class="easyui-panel" title="Admin Menu" style="width: 300px">
				<div style="padding: 10px 0px 10px 60px">
					<be>
					<br>
					<a href="VendorSelection.jsp">Add Menu items</a> <br>
					<br>
					<br>
					<a href="Report.jsp">Reports</a> <br>
					<br>
					<br>
					<a href="UserSelection.jsp">User Choice</a>
				</div>
			</div>
		</div>


		<br> <br> <br>

	</center>
</body>
</html>