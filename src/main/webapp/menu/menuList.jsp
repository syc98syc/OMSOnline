<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 메뉴 조회</title>
<link rel="stylesheet" href="../css/menu.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<h1>주문관리시스템 - 관리자</h1>
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
				<a href="${cpath }/main/managerMain.go" class="btn btn-secondary">메인메뉴로</a>
				<a href="${path}/menuInsert.go" class="btn btn-secondary me-md-2">메뉴추가</a>
			</div>
			<hr>
			<h1>메뉴 목록</h1>
			<table border="1" class="table table-striped table-hover">
				<tr>
					<th>메뉴코드</th>
					<th>이름</th>
					<th>카테고리</th>
					<th>가격</th>
					<th>삭제</th>
				</tr>
				<c:forEach var="menu" items="${mlist}">
					<tr>
						<td id="event" onClick="location.href='${path}/menuDetail.go?menu_code=${menu.menu_code}'" style="cursor:pointer;">${menu.menu_code}</td>
						<td id="event" onClick="location.href='${path}/menuDetail.go?menu_code=${menu.menu_code}'" style="cursor:pointer;">${menu.name}</td>
						<td id="event" onClick="location.href='${path}/menuDetail.go?menu_code=${menu.menu_code}'" style="cursor:pointer;">${menu.category}</td>
						<td id="event" onClick="location.href='${path}/menuDetail.go?menu_code=${menu.menu_code}'" style="cursor:pointer;">${menu.price}</td>
						<td><button
								onclick="location.href='${path}/menuDelete.go?menu_code=${menu.menu_code}'"
								class="btn btn-secondary btn-sm">삭제</button></td>
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