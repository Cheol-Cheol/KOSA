<%@page import="servlet.subject.signup.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="servlet.subject.signup.model.Member" />
<jsp:setProperty property="*" name="member" />

<%
	MemberDao dao = MemberDao.getInstance();
	dao.insert(member);
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