<%@page import="com.vz.letustry.UserDtlsBean"%><%@page import="com.vz.letustry.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		
		String rating  = "";
		String comments = "";
		
		
		VendorSelectionDAO vendorDao = new VendorSelectionDAO();
		
		int userID=0;
		String date1="";
		String itemsSelected="";
		
		if(request.getParameter("vIdSelected")!=null&& !(request.getParameter("vIdSelected").equals("")))
			userID=Integer.parseInt(request.getParameter("vIdSelected"));
		
		if(request.getParameter("date")!=null&& !(request.getParameter("date").equals("")))
			date1=request.getParameter("date");
		
		if(request.getParameter("itemsSelected")!=null&& !(request.getParameter("itemsSelected").equals("")))
			itemsSelected=request.getParameter("itemsSelected");
		
		/*if(session.getAttribute("userId")!=null&& !(session.getAttribute("userId").equals("")))
			userID=Integer.parseInt((String)session.getAttribute("userId"));*/
				
		
		boolean isAdded = vendorDao.addVendorSelectionDetails(userID, date1, itemsSelected);
		if (isAdded) {
			System.out.println("SUCCESS");
			response.sendRedirect("Success.jsp");
			request.getRequestDispatcher("Success.jsp")
			.forward(request, response);
			//

		} else {
			System.out.println("FAILED");
			request.getRequestDispatcher("Failure.jsp")
					.forward(request, response);
			//
		}
	%>

</body>
</html>