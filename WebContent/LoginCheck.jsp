<%@page import="com.vz.letustry.UserDtlsBean"%>
<%@page import="com.vz.letustry.UserDetailDAO"%>
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
		String vzid = "";
		String pwd = "";
		vzid = request.getParameter("vzid");
		pwd = request.getParameter("pwd");
		UserDetailDAO userDao = new UserDetailDAO();
		UserDtlsBean user = new UserDtlsBean();
		user = userDao.getUserDetails(vzid, pwd);
		if (user != null) {
			if (pwd.equals(user.getPassword())) {
				System.out.println("Incorrect password");
				request.getRequestDispatcher("Home.jsp").forward(request,
						response);
			} else {
				System.out.println("Correct password");
				user.getPassword();
				user.getRole();
				String userId = user.getUserid();
				String VzId = user.getVzid();
				session.setAttribute("userId", userId);
				session.setAttribute("vzId", VzId);
				request.getRequestDispatcher(
						"Home.jsp?msg=Invalid UserName or Password")
						.forward(request, response);

			}

		} else {
			request.getRequestDispatcher("Login.jsp?msg=User Doesnt exist")
					.forward(request, response);
		}
	%>

</body>
</html>