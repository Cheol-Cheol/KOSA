<%@page import="servlet.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="servlet.model.Board" />
<jsp:setProperty property="*" name="board" />

<%
	BoardDao dao = BoardDao.getInstance();
	int re = dao.insert(board);
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