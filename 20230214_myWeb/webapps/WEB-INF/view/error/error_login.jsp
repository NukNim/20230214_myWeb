<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("errorMsg") %>
	
	
	<h4>로그인이 되지 않았습니다. 정보가 없습니다.</h4>
	<a href="<%=request.getContextPath()%>/login">로그인페이지로 이동</a>
	
	
	<script type="text/javascript">
		var msg = "${errorMsg}";
		
		var msg1 = "<%=request.getAttribute("errorMsg") %>";
		
		alert(msg);
	</script>
</body>

</html>