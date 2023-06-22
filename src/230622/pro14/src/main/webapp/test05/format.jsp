<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>

 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="money" value="100000000000" ></c:set>
<c:set var="now" value="<%= new Date() %>" ></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<fmt:formatNumber type="number" value="${money }"></fmt:formatNumber>
통화로 변경!<fmt:formatNumber type="currency" value="${money }"></fmt:formatNumber>

<fmt:formatDate value="${now }"  dateStyle="full" />
<fmt:formatDate value="${now }"  dateStyle="short" />
<fmt:formatDate value="${now }"  type="time" />

<hr>

<c:set var="title1" value="hello world" />
<c:set var="title2" value="nice day" />

${fn:length(title1) } <br>

${fn:toUpperCase(title1) }<br>
${fn:toLowerCase(title1) }<br>

${fn:substring(title1,2,7) } <br>

${fn:trim(title1) }nice <br>
${fn:replace(title1,"","/") } <br>
${fn:indexOf(title1,5) } <br>
${fn:contains(title1,title2) } <br>






</body>
</html>