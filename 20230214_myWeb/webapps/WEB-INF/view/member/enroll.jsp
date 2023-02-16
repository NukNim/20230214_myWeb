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
			<button type="button" id="dupid">id 중복 확인</button>
			<span></span>
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

<script type="text/javascript">

	$("#dupid").click(checkDupId);
	
	function checkDupId(){
		$.ajax({
			url : "<%=request.getContextPath() %>/dupid.lo",
			type : "post",
			async : false,
		    /* dataType : 'json', 받을 결과데이터의 자료형 
		    contentType : 'application/json; charset:utf-8', 
		    data : JSON.stringify(test), JSON 타입 데이터 입력*/
			data : {id : $("input[type = text]").first().val()},		
			sucess : function(result){
				console.log(result);
				if(result == "1"){
					$("#dupid").next().html("중복 아이디가 있습니다. 다시 입력해주세요");
					$("#dupid").next().css.("color","red");
				}else{
					$("#dupid").next().html("사용가능 아이디 입니다.");
					$("#dupid").next().css.("color","blue");
				}
			},
			error : function(request, status, error){
				alert(request.statis)
				console.log(result + "error");
			}
		});
	}
	
</script>
</html>