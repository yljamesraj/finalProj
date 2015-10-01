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
		
		
		UserSelectionDAO userDao = new UserSelectionDAO();
		
		int userID=0;
		int menuID=0;
		if(request.getParameter("menuIdSelected")!=null&& !(request.getParameter("menuIdSelected").equals("")))
			menuID=Integer.parseInt(request.getParameter("menuIdSelected"));
		if(session.getAttribute("userId")!=null&& !(session.getAttribute("userId").equals("")))
			userID=Integer.parseInt((String)session.getAttribute("userId"));
				
		
		boolean isAdded = userDao.addUserSelectionDetails(userID, menuID);
		if (isAdded) {
			request.getRequestDispatcher("Success.jsp")
			.forward(request, response);
			//System.out.println("SUCCESS1111");

		} else {
			request.getRequestDispatcher("Failure.jsp")
					.forward(request, response);
			//System.out.println("FAILED");
		}
	%>

</body>
</html>