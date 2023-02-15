<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH 로그인</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/view/header.jsp" %>

	<section>
		<form action="login" method="post">
			id:<input type="text" name="id"> 
			<br>
			pw:<input type="password" name="passwd">
			<br>
			<button type="submit">로그인하기</button>
			<button type="button" class="btn enroll">회원가입</button>
		</form>
	</section>


	<script type="text/javascript">
		$(".btn.enroll").on("click", handlerClickBtnEnroll);
		
		function handlerClickBtnEnroll(){
			location.href = "<%=request.getContextPath()%>/enroll";
		}
	</script>
</body>
</html>