<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20230214_myWeb home</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/view/header.jsp" %>
	
	
	<h1> 메인 페이지</h1>
	
	<script type="text/javascript">
		$(".btn.login").on("click", handlerClickBtnLogin);
		$(".btn.logout").on("click", handlerClickBtnLogout);
		$(".btn.logout").on("click", handlerClickBtnMyinfo);
		
		
		function handlerClickBtnLogin(){
			console.log("btnlogin 버튼 눌림");
			location.href = "<%=request.getContextPath()%>/login";
		}
		function handlerClickBtnLogout(){
			console.log("btnlogout 버튼 눌림");
		}
		function handlerClickBtnMyinfo(){
			console.log("myinfo 버튼 눌림");
			location.href = "<%=request.getContextPath()%>/myinfo";
		}
	</script>
	
	<c:if test=" ${not empty lgnss}"></c:if>
	<button type="button">
			내정보보기
	</button>

</body>
</html>