<%@page import="servlet.subject.s01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button {
	width: 10%;
	margin-top: 15px;
	padding: 10px 15px;
	background-color: white;
	border: 1px solid black;
	border-radius: 7px;
	margin-top: 15px;
	cursor: pointer;
}

button:hover {
	background-color: #eee
}
</style>
</head>
<body>
	<c:if test="${not empty sessionScope.auth}">
		<c:set var="loginMember" value="${sessionScope.auth}" />
		<h3>${loginMember.name}님&nbsp;반갑습니다.</h3>
	</c:if>

	<form action="/addToCart" method="post">
		<c:forEach var="product" items="${productList}">
			<input type="checkbox" name="selectedProducts"
				value="${product.getSeq()}" />
				${product.getProduct_name() }
		</c:forEach>
		<br />
		<button type="submit">장바구니 추가</button>
	</form>
</body>
</html>