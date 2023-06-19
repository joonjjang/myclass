<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
request.setCharacterEncoding("utf-8");
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1.jsp</title>
</head>
<body>
  안녕하세요. 쇼핑몰 중심 JSP 시작입니다!!!
<br>
<jsp:include  page="duke_image.jsp"  flush="true" > //jsp include는 단순히 다른 jsp에 포함 시키는 것을 말한다.
   <jsp:param name= "name"  value="듀크" />            
   <jsp:param name="imgName"  value="duke.png" />
   <jsp:param name="tr"  value="호랑이.jpg" />
</jsp:include>
<br>
  안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다.!!!
</body>
</html>
