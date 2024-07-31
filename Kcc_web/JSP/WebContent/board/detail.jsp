<%@page import="servlet.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="servlet.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String seq = request.getParameter("seq");
	BoardDao dao = BoardDao.getInstance();
	List<Board> list = dao.listBoard();

	Board output = null;
	for (int i = 0; i < list.size(); i++) {
		if (list.get(i).getSeq() == Integer.parseInt(seq)) {
			output = list.get(i);
			break;
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h1>게시글 내용</h1>
	<%
		if (output != null) {
	%>
	<table border="1">
		<tr>
			<th>번호</th>
			<td><%=output.getSeq()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=output.getTitle()%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=output.getWriter()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=output.getContents()%></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=output.getRegdate()%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=output.getHitcount()%></td>
		</tr>
	</table>
	<%
		} else {
	%>
	<p>해당하는 글을 찾을 수 없습니다.</p>
	<%
		}
	%>
</body>
</html>
