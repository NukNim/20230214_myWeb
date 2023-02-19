<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section>
	<h1>게시글 목록</h1>
	<c:forEach var="vo" items="${boardlist}">
		${vo.boardNum} <br>
	</c:forEach>
	<hr>
	 ${boardlist}
	<hr>
</section>