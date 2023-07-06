<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>

<h2 align="center">회원조회하기</h2>
<form action="${contextPath}/mem.do" align="center" >
		<input type="hidden" name="action" value="saerchMember">
	이름 : <input type="text" name="name"> <input type="submit" value="검색">
</form>

<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>아이디</b></td>
      <td><b>비밀번호</b></td>
      <td><b>이름</b></td>
      <td><b>이메일</b></td>
      <td><b>가입일</b></td>
      <td><b>삭제</b></td>
      
   </tr>
   
 <c:forEach var="member" items="${membersList}" >     
   <tr align="center">
      <td>${member.id}</td>
      <td>${member.pwd}</td>
      <td>${member.name}</td>
      <td>${member.email}</td>
      <td>${member.joinDate}</td>
      <td><a href="${contextPath}/mem.do?action=delMember&id=${member.id}">삭제하기</a></td>
      
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/test01/memberForm.jsp"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>
