<%@ page language="java"  contentType="text/html; charset=UTF-8"
      import="java.util.*, sec02.ex01.*" pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");  
%>
<jsp:useBean  id="m"  class="sec02.ex01.MemberBeen"  scope="page"/>
<jsp:setProperty name="m" property="*" />

<%

   MemberDAO  memberDAO=new MemberDAO();
   memberDAO.addMember(m);
   List membersList = memberDAO.listMembers();	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
 <table align="center"  width="100%">
	 <tr align="center" bgcolor="#99ccff">
	    <td width="7%" >아이디</td>
	    <td width="7%">비밀번호</td>
	    <td width="5%" >이름</td>
	    <td width="11%" >이메일</td>
	</tr>
	<%-- <tr align="center">
	  		<td> <jsp:getProperty name="m"  property="id"  /> </td>
            <td> <jsp:getProperty name="m"  property="pwd"  />  </td>
            <td> <jsp:getProperty name="m"  property="name"     /> </td>
            <td> <jsp:getProperty name="m"  property="email"  /> </td>
	    </tr> --%>
	    <%
	   if(membersList.size()==0){
	%>
	  <tr>
	      <td colspan="5">
	        <p align="center"><b><span style="font-size:9pt;">
	                      등록된 회원이  없습니다.</span></b></p>
	      </td>
	  </tr>
	<%
	}else{
	   for( int i = 0; i < membersList.size(); i++ ) {
	      MemberBeen bean = (MemberBeen) membersList.get(i);
	%>
	   <tr align="center">
	       <td><%=bean.getId() %></td>
	       <td><%=bean.getPwd() %></td>
	       <td><%=bean.getName() %></td>
	       <td><%=bean.getEmail() %></td>
	       <td><%=bean.getJoindate() %></td>
	   </tr>
	<%
	      } // end for
	
	   } // end if
	%>
	    
	    <tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
	    </tr>
	</table>
</body>
</html>   
