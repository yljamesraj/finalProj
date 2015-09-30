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
<script type="text/javascript">
function submitForm()
{
	var vzid= document.getElementById("vzid").value;
	var pwd= document.getElementById("password").value;
	window.location.replace("LoginCheck.jsp?vzid="+vzid+"&pwd="+pwd);
	
	}
function clearForm()
{
	$('#loginfrm').form('clear');
	
	}	
</script>
<title>Login</title>
</head>
<body>
	<form id="loginfrm" method="post" action="">

		<center>
			<br> <br>
			<div style="margin: 10px 0;">
				<div class="easyui-panel" title="Login" style="width: 300px">
					<div style="padding: 10px 0px 10px 60px">
						<table>
							<tr>
								<td>VZID</td>
								<td><input class="easyui-validatebox" type="text"
									name="vzid" id="vzid" data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input class="easyui-validatebox" type="password"
									name="password" id="password" data-options="required:true"></input></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="easyui-panel" style="text-align: center; padding: 8px;width: 300px">
					<a href="javascript:void(0)" class=easyui-linkbutton
						" onclick="submitForm()"> Login</a> <a href="javascript:void(0)"
						class=easyui-linkbutton " onclick="clearForm()"> Reset</a>
				</div>
				<%
					String msg = request.getParameter("loginMsg");
					if(msg!=null)
					{
					%>
					<label><font color="blue"><%=msg %></font></label>
					<%} %>
		</center>
		</table>

		</center>
	</form>
</body>
</html>