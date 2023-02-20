<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section>
	<h1>게시글 목록</h1>
	<table>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성시간</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="vo" items="${boardlist}">
			<tr>
				<td>${vo.boardNum}</td>
				<td>${vo.boardTitle}</td>
				<td>${vo.boardWrite}</td>
				<td>${vo.boardDate}</td>
				<td>${vo.boardReadcount}</td>
			</tr>
		 <br>
		</c:forEach>
	</table>
	<hr>
	 <div>
	 <c:if test="${startPageNum > 1}">
	 <span>이전</span>
	 </c:if>
	 
	 <c:forEach begin="${startPageNum}" end="${endPageNum }" step="1" var="page">
		 <c:choose>
		 	<c:when test="${page eq currentPage}">
		 		<span><b>&nbsp;${page}&nbsp;</b></span>
		 	</c:when>
		 	<c:otherwise>
		 		<span><a href="<%=request.getContextPath()%>/?aaa=${page}"></a>&nbsp;${page}&nbsp;</span>
		 	</c:otherwise>
		 </c:choose>
	 </c:forEach>
	 
	 
	 <c:if test="${endPageNum  < pageCnt}">
	 <span>다음</span>
	 </c:if>
<!-- 	 	request.setAttribute("startPageNum", startPageNum); -->
<!-- 		request.setAttribute("endPageNum", endPageNum); -->
<!-- 		request.setAttribute("currentPage", currentPage); -->
<!-- 		request.setAttribute("pageCnt", pageCnt); -->
	 </div>
	<hr>
</section>