<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec01.ex01.*,java.util.*"
    %>
    
    
<%

List<MemberBean> mlist = new ArrayList<MemberBean>();

MemberBean member1 =  new MemberBean("lee", "1234", "이순신", "lee@korea");
MemberBean member2 =  new MemberBean("ling", "1234", "링링", "ling@korea");


mlist.add(member1);
mlist.add(member2);


request.setAttribute("mlist", mlist);

%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<jsp:forward page="member3.jsp"></jsp:forward>

</body>
</html>