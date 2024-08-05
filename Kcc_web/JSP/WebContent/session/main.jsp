<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	// 	String name = (String) session.getAttribute("name");
	// 	if (name == null) {
	// 		response.sendRedirect("loginForm.jsp");
	// 	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty sessionScope.name}">
		<c:set var="name" value="${sessionScope.name}" />
		<b>${name}</b>님 반갑습니다.
	</c:if>
	<br />
	<a href="logout.jsp">로그아웃</a>
</body>
</html>