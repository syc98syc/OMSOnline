<%@page import="com.shinhan.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 메뉴 상세 조회</title>
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
				action="${pageContext.request.servletContext.contextPath }/menu/menuDetail.go"
				method="post">
				menu_code: ${menu.menu_code } <input type="hidden" name="menu_code"
					value="${menu.menu_code }"><br> name:<input
					type="text" name="name" value="${menu.name }"><br>
				category:<input type="text" name="category"
					value="${menu.category }"><br> price:<input
					type="text" name="price" value="${menu.price }"><br>
				<hr>
				<input type="submit" value="수정" class="btn btn-secondary">
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