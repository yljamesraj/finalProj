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
	window.location.replace("LoginCheck.jsp?vzid?vzid="+vzid+"&pwd="+pwd);
	
	}
function clearForm()
{
	$('#loginfrm').form('clear');
	
	}	
</script>
<title>User Food Selection</title>
</head>
<body>
	<form id="userSelectionfrm" method="post" action="">

		<center>
			<br> <br>
			<div style="margin: 10px 0;">
				<div class="easyui-panel" title="Login" style="width: 300px">
				<h2> Today's Menu</h2>
				<h6> Vendor1</h6>
				<input type="Radio" name="Vendor1" value="" checked="checked" class="easyui-validatebox" required="true">
				<input type="Radio" name="Vendor1" value="" checked="checked" class="easyui-validatebox" required="true">
				<input type="Radio" name="Vendor1" value="" checked="checked" class="easyui-validatebox" required="true">
				
				<h6> Vendor2</h6>
				<input type="Radio" name="Vendor2" value="" checked="checked" class="easyui-validatebox" required="true">
				<input type="Radio" name="Vendor2" value="" checked="checked" class="easyui-validatebox" required="true">
				<input type="Radio" name="Vendor2" value="" checked="checked" class="easyui-validatebox" required="true">
				
			
		
				
				
				
			</div>
		</center>
		</table>

		</center>
	</form>
</body>
</html>