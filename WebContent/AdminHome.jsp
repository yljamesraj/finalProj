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

$(document).ready(function() {
    $('#tabs').tabs({
        load: function(event, ui) {
            $(ui.panel).delegate('a', 'click', function(event) {
                $(ui.panel).load(this.href);
                event.preventDefault();
            });
        }
    });

    $("#tabs").bind('tabsselect', function(event, ui) {
        window.location.href=ui.tab;
    });

});
</script>
</head>
<body>

<center>


<br>
<br>
<br>

<!--  <div class="easyui-tabs" style="width:600px;height:100px;">
		<div title="Report" style="padding:10px;">
			<jsp:include page="Report.jsp"/>
		</div>
		<div title="Add Menu item" closable="true" style="padding:10px;">
			Second Tab
		</div>
		<div title="Report" iconCls="icon-reload" closable="true" style="padding:10px;">
			Third Tab
		</div>
		<div title="Add wastage Details" iconCls="icon-reload" closable="true" style="padding:10px;">
			fourth Tab
		</div>
	</div>-->
	
	<div id="tabs">
        <ul>
            <li><a href="Report.jsp"><span>Report</span></a></li>
            <li><a href=""><span>Add Menu item</span></a></li>
          
        </ul>
</div>

</center>

</body>
</html>