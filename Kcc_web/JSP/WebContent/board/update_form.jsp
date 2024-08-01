<%@page import="servlet.model.Board"%>
<%@page import="servlet.dao.BoardDao2"%>
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
<title>Insert title here</title>
</head>
<body>
	<h3>글수정</h3>
	<hr />
	<form action="updateAction.jsp" method="post">
		<input type="hidden" name="seq" value="<%=board.getSeq()%>" /> 제목: <input
			type="text" name="title" value="<%=board.getTitle()%>" /><br /> 내용:
		<br />
		<textarea name="contents" id="" cols="70" rows="6"
			value="<%=board.getContents()%>"></textarea>
		<br /> <input type="submit" value="등록" />
	</form>
</body>
</html>