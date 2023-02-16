<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kh.member.model.vo.MemberVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty myinfo}">
			<span>내 정보 보기</span> <br>
			<span> id : ${myinfo.id}</span><br>
			<span> name : ${myinfo.name}</span><br>
			<span> email : ${myinfo.email}</span><br>
		</c:when>
		<c:otherwise>
			<h4>로그인이 되지 않았습니다. 정보가 없습니다.</h4>
			<a href="<%=request.getContextPath()%>/login">로그인페이지로 이동</a>
		</c:otherwise>
	</c:choose>

<%-- <%
	Object obj = request.getAttribute("myinfo");
	MemberVO vo = new MemberVO();
	if(obj == null){
%>		
		<h4>로그인이 되지 않았습니다. 정보가 없습니다.</h4>
		<a href="<%=request.getContextPath()%>/login">로그인페이지로 이동</a>
<% 		
	}else{
		if(obj instanceof MemberVO){
			vo = (MemberVO)obj;
%>		
		<span> id : <%=vo.getId() %></span><br>
		<span> name : <%=vo.getName() %></span><br>
		<span> email : <%=vo.getEmail() %></span><br>
<%
		}else{%>
			<h4>로그인이 되지 않았습니다. 정보가 없습니다.</h4>
			<a href="<%=request.getContextPath()%>/login">로그인페이지로 이동</a>
		<%}
	}
%>	 --%>	

<hr>
<button type="button" onclick="location.href = <%=request.getContextPath()%>/">
메인으로</button>

</body>
</html>