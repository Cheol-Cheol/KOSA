<%@page import="servlet.dao.BoardDao2"%>
<%@page import="servlet.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="servlet.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	BoardDao2 dao = BoardDao2.getInstance();
	Board board = dao.detailBoard(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h2>글 세부 보기</h2>
	<ul>
		<li><%=board.getSeq()%></li>
		<li><%=board.getTitle()%></li>
		<li><%=board.getWriter()%></li>
		<li><%=board.getContents()%></li>
	</ul>
	<br />

	<a href="update_form.jsp?seq=<%=board.getSeq()%>">수정하기</a>
</body>
</html>
