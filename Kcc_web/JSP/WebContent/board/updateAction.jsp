<%@page import="servlet.dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="servlet.model.Board" />
<jsp:setProperty property="*" name="board" />

<%
	BoardDao2 dao = BoardDao2.getInstance();
	int re = dao.updateBoard(board);

	if (re == 1) {
		response.sendRedirect("/board/list.jsp");
	} else {
		out.println("실패");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>