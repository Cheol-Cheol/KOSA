<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글목록</h3>
	<a href="board_insert">글쓰기</a>
	<table border="1" width="800">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.seq }</td>
				<td><a href="board_detail${b.seq }">${b.title }</a></td>
				<td>${b.writer }</td>
				<td><fmt:parseDate var="dt" value="${b.regdate }"
						pattern="yyyy-MM-dd"></fmt:parseDate> <fmt:formatDate
						value="${dt }" pattern="yyyy/MM/dd" /></td>
				<td>${b.hitcount }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>


</body>
</html>