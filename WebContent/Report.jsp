<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.vz.letustry.*"%>
<%@ page import="java.util.*"%>

<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<script type="text/javascript">
	function onSelect(date) {

		// alert(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
		var date = date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
				+ date.getDate();
		document.getElementById("date").value = date;
		document.getElementById("report").submit();

	}
</script>
</head>
<body>

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

	
<br>
				<br>
	<%
		String currDate = new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date());
	%>
	<center>
		<div class="easyui-panel" title="Login" style="width: 600px">
			<div style="padding: 10px 0px 10px 60px">
				DATE : <input id="dd" name="dd" class="easyui-datebox"
								data-options="onSelect:onSelect" required="required"> <br>
				<br>


				<%
					ReportDAO obj = new ReportDAO();
					String date1 = currDate;
					if (request.getParameter("date") != null) {
						date1 = request.getParameter("date");
					}

					System.out.println("date " + date1);

					HashMap<String, Integer> countList1 = new HashMap<String, Integer>();
					countList1 = obj.getCount(date1, 1);
					HashMap<String, Integer> countList2 = new HashMap<String, Integer>();
					countList2 = obj.getCount(date1, 2);

					System.out.println("countList2 " + countList2.toString());

					System.out.println("countList1 " + countList1.toString());
				%>


				<h2>VENDOR 1</h2>



				<%
					String display = "";
					for (String key : countList1.keySet()) {

						display += "  " + key + "&nbsp;&nbsp;:&nbsp;&nbsp;"
								+ countList1.get(key) + "<br>";

					}
				%>
				<%=display%>





				<h2>VENDOR 2</h2>
				<%
					String display2 = "";
					for (String key : countList2.keySet()) {

						display2 += "  " + key + "&nbsp;&nbsp;:&nbsp;&nbsp;"
								+ countList2.get(key) + "<br>";
					}
				%>
				<%=display2%>
				<form id="report" name="report" action="Report.jsp">
					<input type="hidden" id="date" name="date" value="">

				</form>

				<%
					String item1 = "";
					int maxValue1 = Integer.MIN_VALUE;
					for (int value : countList1.values()) {
						if (value > maxValue1) {
							maxValue1 = value;

						}
					}
					String item2 = "";
					int maxValue2 = Integer.MIN_VALUE;
					for (int value : countList2.values()) {
						if (value > maxValue2) {
							maxValue2 = value;
						}
					}

					System.out.println("maxValue1" + maxValue1);
					System.out.println("maxValue2 " + maxValue2);
				%>

				<h4>
					Today's Menu -
					<%=date1%></h4>
				Vendor 1 :
				<%=obj.getKeysFromValue(countList1, maxValue1)%><br> Vendor 2 :
				<%=obj.getKeysFromValue(countList2, maxValue2)%>
			</div>
		</div>
	</center>

			</body>
</html>