<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored="false"
    %>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />    

<%
  request.setCharacterEncoding("UTF-8");
%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- enctype="multipart/form-data" 는 파일이 이미지일 때 반드시 폼 태그에 삽입해줘야 	함 -->
   <form action="${contextPath}/upload.do"  method="post" enctype="multipart/form-data" >
      파일1: <input type="file" name="file1" ><br>
      파일2: <input type="file" name="file2" > <br>
      파라미터1: <input type="text" name="param1" > <br>
      파라미터2: <input type="text" name="param2" > <br>
      파라미터3: <input type="text" name="param3" > <br>
 <input type="submit" value="UP" >
</form>

</body>
</html>