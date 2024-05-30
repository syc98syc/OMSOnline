<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<a href="javascript:history.back();" class="btn btn-secondary">뒤로가기</a>
			</div>
			<hr>
			<form
				action="${pageContext.request.servletContext.contextPath }/order/orderDetail.go"
				method="post">
				order_code: <input type="text" value="${order.order_code }"
					name="order_code" readonly><br> menu_code: <input
					type="text" value="${order.menu_code }" name="menu_code" readonly><br>
				member_code: <input type="text" value="${order.member_code }"
					name="member_code" readonly><br> quantity: <input
					type="text" value="${order.quantity }" name="quantity" readonly><br>
				price: <input type="text" value="${order.price }" name="price"
					readonly><br> order_date: <input type="text"
					value="${order.order_date }" name="order_date" readonly><br>
				progress: <input type="text" value="${order.progress }" name="price"
					readonly><br> cancel_or: <input type="text"
					value="${order.cancel_or }" name="price" readonly><br>
				<hr>
				<input type="submit" value="조리시작" class="btn btn-secondary">
			</form>
		</section>
		<%
		MemberDTO loginMem = (MemberDTO) session.getAttribute("loginMem");
		%>
		<footer><%=loginMem.getId()%>님, 환영합니다.
		</footer>
	</div>
</body>
</html>