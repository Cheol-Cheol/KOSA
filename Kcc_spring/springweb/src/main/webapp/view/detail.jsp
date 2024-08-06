<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글 상세보기</h3>
	<table border="1" width="800">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>${board.seq}</td>
			<td>${board.title}</td>
			<td>${board.writer}</td>
			<td>${board.regdate}</td>
			<td>${board.hitcount}</td>
		</tr>
	</table>
	<table border="1" width="800">
		<tr>
			<th>내용</th>
		</tr>
		<tr>
			<td>${board.contents}</td>
		</tr>
	</table>
	<a href="board_list">목록보기</a>
	<a href="board_update_form?seq=${board.seq}">수정하기</a>
</body>
</html>