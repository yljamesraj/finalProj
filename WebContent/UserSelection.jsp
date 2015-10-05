<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.vz.letustry.*"%>
<%@ page import="java.util.*"%>

<%@ page import="java.text.SimpleDateFormat"%>

<%
	VendorSelectionDAO obj = new VendorSelectionDAO();
	String currDate = new SimpleDateFormat("yyyy-MM-dd")
			.format(new Date());
	List vs1 = obj.getVendorMenuDetails(currDate, 12);
	List vs2 = obj.getVendorMenuDetails(currDate, 2);

	String radio1 = "";
	for (int i = 0; i < vs1.size(); i++) {
		VendorSelectionBean vsb = new VendorSelectionBean();
		vsb = (VendorSelectionBean) vs1.get(i);
		radio1 += "<input type=\"Radio\" name=\"1\" value=\""
				+ vsb.getMenuid()
				+ "\"  class=\"easyui-validatebox\" required=\"true\">   "
				+ vsb.getItemname() + "    (" + vsb.getDescription()
				+ ")<br>";
		System.out.println(vsb.getMenuid());
		System.out.println(vsb.getItemname());
		System.out.println(vsb.getDescription());
	}

	String radio2 = "";
	for (int i = 0; i < vs2.size(); i++) {
		VendorSelectionBean vsb = new VendorSelectionBean();
		vsb = (VendorSelectionBean) vs2.get(i);
		radio2 += "<input type=\"Radio\" name=\"2\" value=\""
				+ vsb.getMenuid()
				+ "\"  class=\"easyui-validatebox\" required=\"true\">   "
				+ vsb.getItemname() + "    (" + vsb.getDescription()
				+ ")<br>";
		System.out.println(vsb.getMenuid());
		System.out.println(vsb.getItemname());
		System.out.println(vsb.getDescription());
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="thirdParty/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="thirdParty/js/jquery-1.11.3.js"></script>
<link rel="stylesheet" type="text/css" href="thirdParty/css/easyui.css">
<link rel="stylesheet" type="text/css" href="thirdParty/css/icon.css">

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<script type="text/javascript">
	function submitForm() {
		$('#userSelectionfrm').form('submit', {
			url : 'SaveUserSelection.jsp',
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				alert("Your option is saved...Thank you.")
				//url : 'Success.jsp',
			}
		});

	}
	function clearForm() {
		$('#userSelectionfrm').form('clear');
		$('input[name="1"]').attr('disabled', false);
		$('input[name="2"]').attr('disabled', false);

	}
	$(document).ready(function() {

		$('input:radio[name=1]').click(function() {
			var val = $(this).val();
			var menuSel = document.getElementById('menuIdSelected');
			menuSel.value = val;

			$('input[name="2"]').attr('disabled', 'disabled');

		});
	});
	$(document).ready(function() {

		$('input:radio[name=2]').click(function() {
			//  var val = $('input:radio[name=theme]:checked').val();
			var val = $(this).val();
			var menuSel = document.getElementById('menuIdSelected');
			menuSel.value = val;
			$('input[name="1"]').attr('disabled', 'disabled');
		});
	});
</script>
<title>User Food Selection</title>
</head>

<body onload="getTodayMenu()">
	<table bgcolor="#EoECFF" width="100%">
		<tr height="69">
			<td><center>
					<font size="500px" color="#6251A6">VZ SNACKS </font>
				</center></td>
		</tr>
	</table>
	<br>
	<font color="#6251A6" font-weight=" bold">
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
	

	<form id="userSelectionfrm" method="post" action="">
		<input type="hidden" value="" id="menuIdSelected"
			name="menuIdSelected" />
		<center>
			<br>
	
			<div style="margin: 10px 0;">
				<div class="easyui-panel" title="Today's Menu" style="width: 500px">
					<div style="padding: 10px 0px 10px 60px">
						<h2>Vendor 1</h2>
						<%=radio1%>
						<h2>Vendor 2</h2>
						<%=radio2%>

						<%
									System.out.println(radio1);
									System.out.println(radio2);
								%>
						<br> <br> <br> Please give your rating for
						yesterday snacks:<br> <input type="Radio" name="Rating"
							value="1" class="easyui-validatebox" required="true"> 5 <input
							type="Radio" name="Rating" value="1" class="easyui-validatebox"
							required="true"> 4 <input type="Radio" name="Rating"
							value="1" class="easyui-validatebox" required="true"> 3 <input
							type="Radio" name="Rating" value="1" class="easyui-validatebox"
							required="true"> 2 <input type="Radio" name="Rating"
							value="1" class="easyui-validatebox" required="true"> 1 <br>
						<br>Comments: <br>
						<textarea cols="30" rows="5" id="message" name="message"></textarea>
						<br> <br> <br>
					</div>
					<div style="text-align: center; padding: 8px">
						<a href="javascript:void(0)" class=easyui-linkbutton
							" onclick="submitForm()"> Submit</a> <a href="javascript:void(0)"
							class=easyui-linkbutton " onclick="clearForm()"> Reset</a>
					</div>
					<%
								String msg = request.getParameter("msg");
								if (msg != null) {
							%>
					<label><font color="blue"><%=msg %></font></label>
					<%} %>

				</div>
		</center>
		
	</form>
</body>
</html>