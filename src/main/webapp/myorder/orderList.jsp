<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 - 주문내역</title>
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
				value="${pageContext.request.servletContext.contextPath}/myorder" />
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
			<h1>나의 주문 내역</h1>
			<table border="1" class="table table-striped table-hover">
				<tr>
					<th>order_code</th>
					<th>menu_code</th>
					<th>member_code</th>
					<th>quantity</th>
					<th>price</th>
					<th>order_date</th>
					<th>progress</th>
					<th>cancel_or</th>
				</tr>
				<c:forEach var="order" items="${olist}">
					<tr onClick="location.href='${path}/orderDetail.do?order_code=${order.order_code}'" style="cursor:pointer;">
						<td id="event">${order.order_code}</td>
						<td id="event">${order.menu_code}</td>
						<td id="event">${order.member_code}</td>
						<td id="event">${order.quantity}</td>
						<td id="event">${order.price}</td>
						<td id="event">${order.order_date}</td>
						<td id="event">${order.progress}</td>
						<td id="event">${order.cancel_or}</td>
					</tr>
				</c:forEach>
			</table>
		</section>
		<%
		MemberDTO loginMem = (MemberDTO) session.getAttribute("loginMem");
		%>
		<footer><%=loginMem.getId()%>님, 환영합니다.
		</footer>
	</div>
</body>
</html>