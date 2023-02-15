<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH 회원가입</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/view/header.jsp" %>
	<section>
		<h1>회원가입</h1>
		<form action="enroll" method="post">
			id:<input type="text" name="id"> 
			<br>
			pw:<input type="password" name="passwd">
			<br>
			name:<input type="text" name="name">
			<br>
			email:<input type="text" name="email">
			<br>
			<button type="submit" class="btn enroll">회원가입</button>
		</form>
	</section>

</body>
</html>