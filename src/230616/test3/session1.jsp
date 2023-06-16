<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="javax.servlet.RequestDispatcher"
    %>

<%
/* String str = (String) application.getAttribute("food");

application.setAttribute("address", "미금역");
 */

 
 request.setAttribute("asd", "점심이다");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
RequestDispatcher rds = request.getRequestDispatcher("session2.jsp");
rds.forward(request, response);
%>



</body>
</html>