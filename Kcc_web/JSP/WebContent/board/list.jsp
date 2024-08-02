<%@page import="servlet.model.Blog"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="servlet.model.Search"%>
<%@page import="servlet.dao.BoardDao2"%>
<%@page import="servlet.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="servlet.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("utf-8");
	Search search = new Search();
	search.setArea(request.getParameterValues("area"));
	search.setSearchKey("%" + request.getParameter("searchKey") + "%");

	// 	Map map = new HashMap();
	// 	map.put("area", request.getParameterValues("area"));
	// 	map.put("searchKey", "%" + request.getParameter("searchKey") + "%");

	BoardDao2 dao = BoardDao2.getInstance();
	List<Board> list = dao.listBoard(search);
	//System.out.println(list);

	Blog blog = dao.selectBlog(100);
	System.out.println(blog);

	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글목록</h3>
	<a href="/board/insert_form.jsp">글쓰기</a>
	<table border="1" width="800">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="el" items="${list}">

			<tr>
				<td>${el.getSeq()}</td>
				<td><a href="detail.jsp?seq=${el.getSeq()}">${el.getTitle()}</a></td>
				<td>${el.getWriter()}</td>
				<td><fmt:parseDate var="dt" value="${el.getRegdate()}"
						pattern="yyyy-MM-dd" /> <fmt:formatDate value="${dt}"
						pattern="yyyy/MM/dd" /></td>
				<td>${el.getHitcount()}</td>
			</tr>

		</c:forEach>

	</table>
	<br>
	<br>

	<form action="list.jsp" method="get">
		<input type="checkbox" name="area" value="title">제목 <input
			type="checkbox" name="area" value="writer">작성자 <input
			type="text" name="searchKey" size="10"> <input type="submit"
			value="검색">
	</form>

</body>
</html>












