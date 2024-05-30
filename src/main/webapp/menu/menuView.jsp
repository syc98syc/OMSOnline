<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 - 메뉴 조회</title>
<link rel="stylesheet" href="../css/menu.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템 - 사용자</h1>
		</header>
		<section>

			<c:set var="path"
				value="${pageContext.request.servletContext.contextPath}/menu" />
			<c:set var="cpath"
				value="${pageContext.request.servletContext.contextPath}" />


			<%
			request.setCharacterEncoding("utf-8");
			%>

			<script src="${cpath }/js/jquery.min.js"></script>


			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<a href="${cpath }/main/regularUserMain.do"
					class="btn btn-secondary">메인메뉴로</a>
			</div>
			<hr>
			<h1>메뉴 목록</h1>
			<table border="1" class="table table-striped table-hover">
				<tr>
					<th>menu_code</th>
					<th>name</th>
					<th>category</th>
					<th>price</th>
				</tr>
				<c:forEach var="menu" items="${mlist}">
					<tr>
						<td>${menu.menu_code}</td>
						<td>${menu.name}</td>
						<td>${menu.category}</td>
						<td>${menu.price}</td>
					</tr>
				</c:forEach>
			</table>
			
		</section>
			<%
			MemberDTO loginMem = (MemberDTO) session.getAttribute("loginMem");
			%>
		<footer><%=loginMem.getId()%>님, 환영합니다.</footer>
	</div>
</body>
</html>