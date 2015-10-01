<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.vz.letustry.*"%>
<%@ page import="java.util.*"%>

<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<script type="text/javascript">
	var itemsSelected = "";

	function submitForm() {

		var rr = [];
		$('#lstBox2 option').each(function(i, selected) {
			rr[i] = $(selected).val();
		});
		//alert(rr);

		document.getElementById("itemsSelected").value = rr;

		$('#VendorSelectionfrm').form('submit', {
			url : 'SaveVendorSelection.jsp',
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				alert("Your option is saved...Thank you.")
			}
		});

	}

	$(document).ready(function() {
		$('#btnRight').click(function(e) {
			var selectedOpts = $('#lstBox1 option:selected');
			if (selectedOpts.length == 0) {
				alert("Nothing to move.");
				e.preventDefault();
			}

			$('#lstBox2').append($(selectedOpts).clone());
			$(selectedOpts).remove();
			e.preventDefault();

		});

		$('#btnLeft').click(function(e) {
			var selectedOpts = $('#lstBox2 option:selected');

			if (selectedOpts.length == 0) {
				alert("Nothing to move.");
				e.preventDefault();
			}

			$('#lstBox1').append($(selectedOpts).clone());
			$(selectedOpts).remove();
			e.preventDefault();
		});

	});
	function onSelect(date) {

		// alert(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
		var date = date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
				+ date.getDate();
		document.getElementById("date").value = date;

	}
	
	 $(document).ready(function () {

			$('input:radio[name=Vendor]').click(function() {
				  var val = $(this).val(); 
				  //alert(val);
				  var menuSel=document.getElementById('vIdSelected');
				  menuSel.value=val;
				 
			

				});
			   });
</script>
<title>User Food Selection</title>
</head>
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
<td style="width:200px"></td>
<td><a href="AdminHome.jsp">Home</a></td>
<td>Welcome <%=(String) session.getAttribute("vzId")%></td>
<td><a href="logout.jsp">Logout</a></td>
			</tr>



</table>
<body onload="getTodayMenu()">
	<form id="VendorSelectionfrm" method="post" action="">
		<input type="hidden" id="itemsSelected" name="itemsSelected">
		<input type="hidden" id="date" name="date" value="">
		<input type ="hidden" value="" id="vIdSelected" name="vIdSelected"/>
		<center>
			<br> <br>
			<div style="margin: 10px 0;">
				<div class="easyui-panel" title="Select Menu" style="width: 650px">
					<div style="padding: 10px 0px 10px 60px">
						<b>DATE : </b><input id="dd" name="dd" class="easyui-datebox"
							data-options="onSelect:onSelect" required="required"> <br>
						<br> 
						
						<br>
						<b>Select Vendor</b><br><br>
						<font size="3px"></font><input type="Radio" name="Vendor" value="1"
							class="easyui-validatebox" required="true"> Vendor 1 <input
							type="Radio" name="Vendor" value="2"
							class="easyui-validatebox" required="true"> Vendor 2 </font>
<br><br>
						<table style='width: 470px;'>
							<tr>
								<td style='width: 260px;'><b>Available menu Items:</b><br />


									<%
										MenuDtlsDAO obj = new MenuDtlsDAO();

										List vs1 = obj.getAllMenuDetails();
										String options = "";
										for (int i = 0; i < vs1.size(); i++) {
											MenuDtlsBean vsb = new MenuDtlsBean();
											vsb = (MenuDtlsBean) vs1.get(i);
											options += "<option value=\"" + vsb.getMenuid() + "\">"
													+ vsb.getItemname() + "</option>";

										}
										System.out.println(options);
									%> <select multiple="multiple" id='lstBox1'
									style="width: 170px; height: 290px">
										<%=options%>

								</select></td>
								<td
									style='width: 150px; text-align: center; vertical-align: middle;'>
									<input type='button' id='btnRight' value='  >  ' /> <br />
								<input type='button' id='btnLeft' value='  <  ' />
								</td>
								<td style='width: 160px;'><b>Selected menu Items: </b><br />
									<select multiple="multiple" id='lstBox2' style="width: 170px">

								</select></td>
							</tr>
						</table>
						<div style="text-align: center; padding: 8px">
							<a href="javascript:void(0)" class=easyui-linkbutton
								" onclick="submitForm()"> Submit</a> <a
								href="javascript:void(0)" class=easyui-linkbutton
								" onclick="clearForm()"> Reset</a>
						</div>
					</div>
				</div>
			</div>
		</center>
	</form>
</body>
</html>